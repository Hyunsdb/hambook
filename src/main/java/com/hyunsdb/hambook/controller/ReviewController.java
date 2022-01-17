package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.BookReviewDto;
import com.hyunsdb.hambook.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/review")
@RequiredArgsConstructor
public class ReviewController {
    public final ReviewService reviewService;

    @PostMapping("{rid}")
    public ResponseEntity addReview(@RequestBody BookReviewDto bookReviewDto) {
        Long reviewNo = reviewService.addReview(bookReviewDto);
        return new ResponseEntity<>(reviewNo, HttpStatus.OK);
    }
}
