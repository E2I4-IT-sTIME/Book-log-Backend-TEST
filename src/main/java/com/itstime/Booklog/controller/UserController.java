package com.itstime.Booklog.controller;

import com.itstime.Booklog.config.auth.PrincipalDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/test/login")
    public @ResponseBody String testLogin(Authentication authentication, @AuthenticationPrincipal PrincipalDetail userDetails){
        System.out.println("/test/login =================");
        PrincipalDetail principalDetail = (PrincipalDetail)authentication.getPrincipal();
        System.out.println("authentication : " + principalDetail.getUser());

        System.out.println("userDetails : " + userDetails.getUser());
        return "세션 정보 확인하기";
    }

    @GetMapping("/test/oauth/login")
    public @ResponseBody String testOAuthLogin(Authentication authentication, @AuthenticationPrincipal OAuth2User oauth){
        System.out.println("/test/oauth/login =================");
        OAuth2User oauth2User = (OAuth2User)authentication.getPrincipal();
        System.out.println("authentication : " + oauth2User.getAttributes());
        System.out.println("oauth2User : " + oauth.getAttributes());

        return "OAuth 세션 정보 확인하기";
    }

    @GetMapping("/user")
    public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetail principalDetail){
        System.out.println("principalDetail = " + principalDetail.getUser());
        return "user";
    }

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
