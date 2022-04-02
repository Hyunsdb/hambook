package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends JpaRepository<Post,Long>, QuerydslPredicateExecutor<Post>, PostSearchRepository {
}
