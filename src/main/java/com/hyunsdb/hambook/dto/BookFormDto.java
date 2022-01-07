package com.hyunsdb.hambook.dto;

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
}
