package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.entity.Post;
import com.hyunsdb.hambook.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getPostList(){
        return postRepository.findAll();
    }
}
