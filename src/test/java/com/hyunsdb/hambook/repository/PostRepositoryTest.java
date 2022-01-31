package com.hyunsdb.hambook.repository;

import com.hyunsdb.hambook.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @BeforeEach
    void clean(){
        postRepository.deleteAll();
    }

    @DisplayName("post add Test")
    @Test
    void addTest(){
        for (int i = 1; i <= 20; i++) {
            Post post = Post.builder()
                    .title("글 제목"+i)
                    .content("글 내용"+i)
                    .writer("작가"+i)
                    .build();
            postRepository.save(post);
        }

        assertThat(postRepository.findAll().size()).isEqualTo(20);
    }


}