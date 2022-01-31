package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.PostFormDto;
import com.hyunsdb.hambook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public String boardList(Model model) {
        model.addAttribute("posts", postService.getPostList());
        return "board/boardList";
    }

    @GetMapping("/post/add")
    public String postAddForm(Model model) {
        model.addAttribute("postFormDto", new PostFormDto());
        return "board/boardForm";
    }

    @PostMapping("/post/add")
    public String postAdd(@ModelAttribute PostFormDto postFormDto) {
        postService.addPost(postFormDto);

        return "redirect:/";
    }

    @GetMapping("/post/{pid}")
    public String postDetail(@PathVariable Long pid, Model model){
        PostFormDto post = postService.getPostDetail(pid);

        model.addAttribute("post", post);
        return "board/postDetail";
    }
}
