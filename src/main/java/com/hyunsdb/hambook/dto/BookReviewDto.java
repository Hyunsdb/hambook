package com.hyunsdb.hambook.dto;

import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    private LocalDateTime regDate, modDate;

    public Review toEntity(){
        return Review.builder()
                .rid(rid)
                .book(Book.builder().bid(bid).build())
                .grade(grade)
                .content(content)
                .build();
    }
}
