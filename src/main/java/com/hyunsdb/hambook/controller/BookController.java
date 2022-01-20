package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.BookFormDto;
import com.hyunsdb.hambook.dto.BookImgDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.service.BookImgService;
import com.hyunsdb.hambook.service.BookService;
import com.hyunsdb.hambook.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookImgService bookImgService;
    private final S3Service s3Service;

    @GetMapping({"/list"})
    public String list(Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<Book> books = bookService.listPage(pageable);
        model.addAttribute("books", books);
        model.addAttribute("maxPage", 5);
        return "book/bookList";
    }

    @GetMapping("/{bookId}")
    public String detail(@PathVariable("bookId") Long bookId, Model model) {
        BookFormDto book = bookService.getDetail(bookId);
        BookImgDto bookImg = bookImgService.getBookImg(bookId);
        model.addAttribute("book", book);
        model.addAttribute("bookImg", bookImg);
        return "/book/bookDetail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("bookFormDto", new BookFormDto());
        return "/book/bookForm";
    }

    @PostMapping("/add")
    public String addBookForm(@ModelAttribute BookFormDto bookFormDto, BookImgDto bookImgDto, MultipartFile file) throws IOException {
        bookImgDto.setImgName(bookFormDto.getName());
        bookImgDto.setFilePath(s3Service.upload(file));
        bookService.saveBook(bookFormDto, bookImgDto);

        return "redirect:/";
    }

    @GetMapping("/{bookId}/edit")
    public String editForm(@PathVariable Long bookId, Model model) {
        BookFormDto book = bookService.getDetail(bookId);
        model.addAttribute("book", book);
        return "book/bookEditForm";
    }

    @PostMapping("/{bookId}/edit")
    public String editBook(@PathVariable Long bookId, BookFormDto bookFormDto) {
        bookService.editBook(bookId, bookFormDto);
        return "redirect:/book/" + bookId;
    }
}
