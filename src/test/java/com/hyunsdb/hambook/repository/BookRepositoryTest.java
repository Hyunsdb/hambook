package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @AfterEach
    void afterEach(){
        bookRepository.deleteAll();
    }

    @Test
    @DisplayName("책 저장 테스트")
    void save(){
        //given
        Book book = Book.builder()
                .name("책 이름")
                .writer("작가")
                .publisher("출판사")
                .build();

        //when
        bookRepository.save(book);

        //then
        Book findBook = bookRepository.findById(book.getBid()).get();
        assertThat(book.getName()).isEqualTo(findBook.getName());
        assertThat(book.getPublisher()).isEqualTo(findBook.getPublisher());
        assertEquals(book.getWriter(), findBook.getWriter());
    }
}