package com.itstime.Booklog.controller;

import com.itstime.Booklog.config.auth.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // 테스트
    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        model.addAttribute("user", principalDetails.getUser());
        return "test";
    }

    // 로그아웃 테스트
    @GetMapping("/logoutForm")
    public String logout() {
        return "logout";
    }

    // 일반로그인
    // 세션 정보 확인 테스트 - 파라미터에 두 가지 방법
    @GetMapping("/test/login")
    public @ResponseBody String testLogin(Authentication authentication, @AuthenticationPrincipal PrincipalDetails userDetails) {
        System.out.println("/test/login ========================");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication = " + principalDetails.getUser());

        System.out.println("userDetails = " + userDetails.getUser());
        return "세션 정보 확인하기";
    }

    // OAuth2 테스트
    @GetMapping("/test/oauth/login")
    public @ResponseBody String testOAuthLogin(Authentication authentication, @AuthenticationPrincipal OAuth2User oauth) {
        System.out.println("/test/oauth/login ========================");
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication = " + oAuth2User.getAttributes());
        System.out.println("oauth = " + oauth.getAttributes());
        return "OAuth 세션 정보 확인하기";
    }

    // PrincipalDetails에 UserDetails, OAuth2User 둘 다 넣은 테스트
    @GetMapping("/user")
    public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails = " + principalDetails.getUser());
        return "user";
    }

    @GetMapping("/test/user")
    public @ResponseBody String testUser(){
        return "이동성공";
    }


}
