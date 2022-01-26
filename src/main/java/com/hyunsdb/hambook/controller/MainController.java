package com.hyunsdb.hambook.controller;

import com.hyunsdb.hambook.config.auth.LoginUser;
import com.hyunsdb.hambook.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MainController {


    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImg", user.getPicture());
        }

        return "index";
    }
}
