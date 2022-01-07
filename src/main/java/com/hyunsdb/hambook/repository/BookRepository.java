package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
