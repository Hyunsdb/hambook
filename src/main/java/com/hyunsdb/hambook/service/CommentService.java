package com.hyunsdb.hambook.service;

import com.hyunsdb.hambook.dto.PostCommentDto;
import com.hyunsdb.hambook.entity.Comment;
import com.hyunsdb.hambook.entity.Post;
import com.hyunsdb.hambook.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public List<PostCommentDto> getCommentList(Long pid){
        Post post = Post.builder().pid(pid).build();

        List<Post> comments = commentRepository.findByPost(post);
        return comments
                .stream()
                .map(postComment -> modelMapper.map(postComment, PostCommentDto.class))
                .collect(Collectors.toList());
    }

    public Long addComment(PostCommentDto postCommentDto) {
        return commentRepository.save(postCommentDto.toEntity()).getCid();
    }

}
