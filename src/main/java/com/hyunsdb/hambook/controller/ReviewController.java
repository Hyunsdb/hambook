package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.BookReviewDto;
import com.hyunsdb.hambook.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/review")
@RequiredArgsConstructor
public class ReviewController {
    public final ReviewService reviewService;

    @GetMapping("/{bid}/list")
    public ResponseEntity<List<BookReviewDto>> reviewList(@PathVariable Long bid){
        List<BookReviewDto> reviewList = reviewService.getReviewList(bid);
        return new ResponseEntity<>(reviewList, HttpStatus.OK);
    }

    @PostMapping("{bid}")
    public ResponseEntity addReview(@RequestBody BookReviewDto bookReviewDto) {
        Long reviewNo = reviewService.addReview(bookReviewDto);
        return new ResponseEntity<>(reviewNo, HttpStatus.OK);
    }

    @DeleteMapping("/{bid}/{rid}")
    public ResponseEntity removeReview(@PathVariable Long rid) {
        reviewService.deleteReview(rid);
        return new ResponseEntity(rid, HttpStatus.OK);
    }

    @PutMapping("/{bid}/{rid}")
    public ResponseEntity modifyReview(@PathVariable Long rid, @RequestBody BookReviewDto bookReviewDto) {
        reviewService.modifyReview(bookReviewDto);

        return new ResponseEntity(rid, HttpStatus.OK);
    }
}
