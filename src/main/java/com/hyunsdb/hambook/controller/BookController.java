package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.BookFormDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("bookFormDto", new BookFormDto());
        return "/book/bookForm";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute BookFormDto bookFormDto) {

        bookService.saveBook(bookFormDto);

        return "redirect:/";
    }

    @GetMapping({"/list"})
    public String list(Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<Book> books = bookService.listPage(pageable);
        model.addAttribute("books", books);
        model.addAttribute("maxPage", 5);
        return "book/bookList";
    }

}
