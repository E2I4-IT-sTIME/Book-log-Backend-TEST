package com.itstime.Booklog.dto;

import com.itstime.Booklog.model.RoleType;
import com.itstime.Booklog.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class JoinDto {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private LocalDate birthday;
    private String job;
    private String area;
    private boolean active;
    private RoleType role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .username(nickname)
                .email(email)
                .birthday(birthday)
                .job(job)
                .area(area)
                .active(true)
                .role(RoleType.USER)
                .build();
    }
}
