package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.dto.BookSearchDto;
import com.hyunsdb.hambook.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookSearchRepository {
    Page<Book> bookSearchPage(BookSearchDto bookSearchDto, Pageable pageable);
}
