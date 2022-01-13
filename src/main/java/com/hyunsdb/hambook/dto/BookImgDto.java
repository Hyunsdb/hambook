package com.hyunsdb.hambook.dto;

import com.hyunsdb.hambook.entity.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookImgDto {
    private Long id;
    private String imgName;
    private String filePath;
    private Book book;

    @Builder
    public BookImgDto(Long id, String imgName, String filePath, Book book) {
        this.id = id;
        this.imgName = imgName;
        this.filePath = filePath;
        this.book = book;
    }
}
