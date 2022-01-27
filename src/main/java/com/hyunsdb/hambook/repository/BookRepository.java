package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookRepository extends JpaRepository<Book,Long>, QuerydslPredicateExecutor<Book>,BookSearchRepository {

    @Query(value = "select b from Book b",
            countQuery = "SELECT count(b) FROM Book b")
    Page<Book> getBookListPage(Pageable pageable);

}
