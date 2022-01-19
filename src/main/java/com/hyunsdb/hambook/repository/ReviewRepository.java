package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByBook(Book book);
}
