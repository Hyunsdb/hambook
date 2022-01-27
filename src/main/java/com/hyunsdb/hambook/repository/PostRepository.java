package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
