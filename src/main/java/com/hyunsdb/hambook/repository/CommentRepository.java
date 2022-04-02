package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Comment;
import com.hyunsdb.hambook.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Post> findByPost(Post post);
}
