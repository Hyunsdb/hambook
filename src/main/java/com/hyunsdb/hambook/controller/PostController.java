package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public String boardList(Model model){
        model.addAttribute("posts", postService.getPostList());
        return "board/boardList";
    }

}
