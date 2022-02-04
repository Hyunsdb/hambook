package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.dto.PostSearchDto;
import com.hyunsdb.hambook.entity.Post;
import com.hyunsdb.hambook.entity.QPost;
import com.hyunsdb.hambook.entity.QUser;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class PostSearchRepositoryImpl implements PostSearchRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Post> postSearchPage(PostSearchDto postSearchDto, Pageable pageable) {
        QueryResults<Post> results = queryFactory.selectFrom(QPost.post)
                .where(searchByLike(postSearchDto.getSearchBy(), postSearchDto.getSearchQuery()))
                .orderBy(QPost.post.pid.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
    private BooleanExpression searchByLike(String searchBy, String searchQuery){
        if(StringUtils.equals("title",searchBy)){
            return QPost.post.title.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("writer", searchBy)) {
            return QPost.post.writer.like("%" + searchQuery + "%");
        }
        return null;
    }
}
