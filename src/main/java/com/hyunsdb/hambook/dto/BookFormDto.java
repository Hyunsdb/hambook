package com.hyunsdb.hambook.dto;

import com.hyunsdb.hambook.entity.BookImg;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookFormDto {
    private Long bid;

    private String name;

    private String writer;

    private String publisher;

    private BookImg bookImg;
}
