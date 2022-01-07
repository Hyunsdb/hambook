package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.BookFormDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public Long saveBook(BookFormDto bookFormDto) {
        Book book = bookRepository.save(modelMapper.map(bookFormDto, Book.class));
        return book.getBid();
    }

}
