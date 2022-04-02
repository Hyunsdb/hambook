package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.dto.BookSearchDto;
import com.hyunsdb.hambook.entity.Book;
import com.hyunsdb.hambook.entity.QBook;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class BookSearchRepositoryImpl implements BookSearchRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Book> bookSearchPage(BookSearchDto bookSearchDto, Pageable pageable) {
        List<Book> content = queryFactory.selectFrom(QBook.book)
                .where(searchByLike(bookSearchDto.getSearchBy(), bookSearchDto.getSearchQuery()))
                .orderBy(QBook.book.bid.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(content, pageable, content.size());
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery) {
        if (StringUtils.equals("name", searchBy)) {
            return QBook.book.name.like("%"+searchQuery+"%");
        } else if (StringUtils.equals("writer",searchBy)) {
            return QBook.book.writer.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("publisher",searchBy)) {
            return QBook.book.publisher.like("%" + searchQuery + "%");
        }
        return null;
    }
}
