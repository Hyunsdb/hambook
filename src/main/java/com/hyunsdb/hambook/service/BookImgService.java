package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.BookImgDto;
import com.hyunsdb.hambook.entity.BookImg;
import com.hyunsdb.hambook.repository.BookImgRepository;
import com.hyunsdb.hambook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookImgService {
    private final BookImgRepository bookImgRepository;
    private final BookRepository bookRepository;
    private final S3Service s3Service;
    private final ModelMapper modelMapper;

    public void saveBookImg(BookImgDto bookImgDto){
        bookImgRepository.save(modelMapper.map(bookImgDto, BookImg.class));
    }

    public BookImgDto getBookImg(Long id){
        BookImg bookImg = bookRepository.findById(id).get().getBookImg();

        return BookImgDto.builder()
                .iid(bookImg.getIid())
                .imgName(bookImg.getImgName())
                .filePath(bookImg.getFilePath())
                .fileFullPath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + bookImg.getFilePath())
                .build();
    }

    public void editBookImg(Long bookId, BookImgDto bookImgDto) {
        Long bookImgId = bookRepository.findById(bookId).get().getBookImg().getIid();
        BookImg bookImg = bookImgRepository.findById(bookImgId).get();
        bookImg.changeBookImg(bookImgDto.getImgName(),
                bookImgDto.getFilePath(),
                bookImgDto.getFileFullPath());
        bookImgRepository.save(bookImg);
    }
}
