package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.BookFormDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addBook(@ModelAttribute BookFormDto bookFormDto){

        bookService.saveBook(bookFormDto);

        return "redirect:/";
    }

}
