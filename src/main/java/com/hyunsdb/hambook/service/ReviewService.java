package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.BookReviewDto;
import com.hyunsdb.hambook.entity.Review;
import com.hyunsdb.hambook.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    public Long addReview(BookReviewDto bookReviewDto) {
        return reviewRepository.save(modelMapper.map(bookReviewDto, Review.class)).getRid();
    }

    public void deleteReview(Long id){
        reviewRepository.deleteById(id);
    }

    public void modifyReview(BookReviewDto bookReviewDto) {
        Optional<Review> review = reviewRepository.findById(bookReviewDto.getRid());

        if (review.isPresent()) {
            Review findReview = review.get();
            findReview.changeGrade(bookReviewDto.getGrade());
            findReview.changeContent(bookReviewDto.getContent());

            reviewRepository.save(findReview);
        }

    }
}
