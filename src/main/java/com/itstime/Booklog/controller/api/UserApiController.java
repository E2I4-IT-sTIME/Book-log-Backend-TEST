package com.itstime.Booklog.controller.api;

import com.itstime.Booklog.dto.JoinDto;
import com.itstime.Booklog.model.User;
import com.itstime.Booklog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/auth/joinProc")
    public String join(JoinDto joinDto) {
        User user = joinDto.toEntity();
        userService.join(user);
        return "loginForm";
    }
}
