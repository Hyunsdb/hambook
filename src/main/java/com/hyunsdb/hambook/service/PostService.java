package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.PostFormDto;
import com.hyunsdb.hambook.entity.Post;
import com.hyunsdb.hambook.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public List<Post> getPostList(){
        return postRepository.findAll();
    }

    public PostFormDto getPostDetail(Long pid) {
        Post findPost = postRepository.findById(pid).get();
        return modelMapper.map(findPost, PostFormDto.class);
    }

    public Long addPost(PostFormDto postFormDto) {
        return postRepository.save(modelMapper.map(postFormDto, Post.class)).getPid();
    }


}
