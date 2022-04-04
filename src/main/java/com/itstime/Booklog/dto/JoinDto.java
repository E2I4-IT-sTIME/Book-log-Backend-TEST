package com.itstime.Booklog.dto;

import com.itstime.Booklog.model.user.RoleType;
import com.itstime.Booklog.model.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Data
@Getter
@Setter
public class JoinDto {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Date birthday;
    private String job;
    private String area;
    private boolean active;
    private RoleType role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .birthday(birthday)
                .job(job)
                .area(area)
                .active(true)
                .role(RoleType.USER)
                .build();
    }
}
