package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.BookFormDto;
import com.hyunsdb.hambook.dto.BookImgDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.entity.BookImg;
import com.hyunsdb.hambook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookImgService bookImgService;
    private final ModelMapper modelMapper;

    public Long saveBook(BookFormDto bookFormDto, BookImgDto bookImgDto) {

        bookFormDto.setBookImg(modelMapper.map(bookImgDto,BookImg.class));
        //bookImgService.saveBookImg(bookImgDto);

        return bookRepository.save(modelMapper.map(bookFormDto, Book.class)).getBid();
    }

    public Page<Book> listPage(Pageable pageable) {
        return bookRepository.getBookListPage(pageable);
    }

    public BookFormDto getDetail(Long id){
        return modelMapper.map(bookRepository.findById(id).get(), BookFormDto.class);
    }

    public Long editBook(Long bookId,BookFormDto bookFormDto){
        Book book = bookRepository.findById(bookId).get();
        book.changeBook(bookFormDto.getName(),
                bookFormDto.getWriter(),
                bookFormDto.getPublisher());
        return bookRepository.save(book).getBid();
    }
}
