package com.itstime.Booklog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // 회원가입 페이지
    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    // 로그인 페이지
    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "/loginForm";
    }
}
