package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.PostFormDto;
import com.hyunsdb.hambook.dto.PostSearchDto;
import com.hyunsdb.hambook.entity.Post;
import com.hyunsdb.hambook.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public Page<Post> getPostList(PostSearchDto postSearchDto, Pageable pageable){
        return postRepository.postSearchPage(postSearchDto, pageable);
    }

    public PostFormDto getPostDetail(Long pid) {
        Post findPost = postRepository.findById(pid).get();
        return modelMapper.map(findPost, PostFormDto.class);
    }

    public Long addPost(PostFormDto postFormDto) {
        return postRepository.save(modelMapper.map(postFormDto, Post.class)).getPid();
    }

    public void editPost(PostFormDto postFormDto) {
        Post post = postRepository.findById(postFormDto.getPid()).get();
        post.updatePost(postFormDto);
    }

}
