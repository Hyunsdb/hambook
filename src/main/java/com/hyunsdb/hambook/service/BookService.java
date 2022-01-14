package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.BookFormDto;
import com.hyunsdb.hambook.dto.BookImgDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookImgService bookImgService;
    private final ModelMapper modelMapper;

    public Long saveBook(BookFormDto bookFormDto, BookImgDto bookImgDto) {
        Book book = bookRepository.save(modelMapper.map(bookFormDto, Book.class));
        bookImgService.saveBookImg(book,bookImgDto);
        return book.getBid();
    }

    public Page<Book> listPage(Pageable pageable) {
        return bookRepository.getBookListPage(pageable);
    }

    public BookFormDto getDetail(Long id){
        return modelMapper.map(bookRepository.findById(id).get(), BookFormDto.class);
    }
}
