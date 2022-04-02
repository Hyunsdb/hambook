package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.PostCommentDto;
import com.hyunsdb.hambook.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board/post")
@RequiredArgsConstructor
public class CommentController {
    public final CommentService commentService;

    @GetMapping("/{pid}/comment/list")
    public ResponseEntity<List<PostCommentDto>> commentList(@PathVariable Long pid, Model model) {
        List<PostCommentDto> commentList = commentService.getCommentList(pid);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @PostMapping("/{pid}/comment")
    public ResponseEntity addComment(@RequestBody PostCommentDto postCommentDto) {
        Long commentNo = commentService.addComment(postCommentDto);
        return new ResponseEntity<>(commentNo, HttpStatus.OK);
    }
}
