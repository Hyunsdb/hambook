package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.BookImgDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.entity.BookImg;
import com.hyunsdb.hambook.repository.BookImgRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookImgService {
    private final BookImgRepository bookImgRepository;
    private final ModelMapper modelMapper;

    public void saveBookImg(Book book, BookImgDto bookImgDto) {
        bookImgDto.setBook(book);
        bookImgRepository.save(modelMapper.map(bookImgDto, BookImg.class));
    }
}
