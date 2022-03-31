package com.itstime.Booklog.controller;

import com.itstime.Booklog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "loginForm";
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id, @AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
        model.addAttribute("user", principalDetail.getUser());
        return "test";
    }

    @GetMapping("/logoutForm")
    public String logout() {
        return "logout";
    }

}
