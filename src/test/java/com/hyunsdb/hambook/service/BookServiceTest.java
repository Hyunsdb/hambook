package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Test
    @DisplayName("책 저장 테스트")
    void save(){
        //given
        Book book = Book.builder()
                .name("new 책 이름")
                .writer("new 글쓴이")
                .publisher("new 출판사")
                .build();

        //when
        bookRepository.save(book);

        Book findBook = bookRepository.findById(book.getBid()).get();

        //then
        assertEquals(book.getName(),findBook.getName());
        assertEquals(book.getWriter(),findBook.getWriter());
        assertEquals(book.getPublisher(),findBook.getPublisher());

    }

}