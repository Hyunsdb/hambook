package com.hyunsdb.hambook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookReviewDto {
    //review
    private Long rid;

    //book
    private Long bid;

    //user
    private Long uid;

    private int grade;

    private String content;
}
