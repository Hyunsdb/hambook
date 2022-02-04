package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.dto.PostFormDto;
import com.hyunsdb.hambook.dto.PostSearchDto;
import com.hyunsdb.hambook.entity.Post;
import com.hyunsdb.hambook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {
    private final PostService postService;

    @GetMapping({"/list", "/list/{page}"})
    public String boardList(@PageableDefault Pageable pageable, PostSearchDto postSearchDto, Model model) {
        //Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 3);
        Page<Post> posts = postService.getPostList(postSearchDto, pageable);
        int totalPages = posts.getTotalPages();

        model.addAttribute("posts", posts);
        model.addAttribute("maxPage", 5);
        model.addAttribute("postSearchDto", postSearchDto);


        return "board/boardList";
    }

    @GetMapping("/post/add")
    public String postAddForm(Model model) {
        model.addAttribute("postFormDto", new PostFormDto());
        return "board/postForm";
    }

    @PostMapping("/post/add")
    public String postAdd(@ModelAttribute PostFormDto postFormDto) {
        postService.addPost(postFormDto);

        return "redirect:/";
    }

    @GetMapping("/post/{pid}")
    public String postDetail(@PathVariable Long pid, Model model) {
        PostFormDto post = postService.getPostDetail(pid);

        model.addAttribute("post", post);
        return "board/postDetail";
    }

    @GetMapping("/post/{pid}/edit")
    public String postEditForm(@PathVariable Long pid, Model model) {
        PostFormDto post = postService.getPostDetail(pid);
        model.addAttribute("post", post);
        return "board/postEditForm";
    }

    @PutMapping("/post/{pid}/edit")
    public String postEdit(@ModelAttribute PostFormDto postFormDto) {
        postService.editPost(postFormDto);

        return "redirect:/";
    }
}
