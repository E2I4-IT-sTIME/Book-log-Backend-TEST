package com.itstime.Booklog.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User")
public class User {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String email;

    private String imgHome;
    private String imgpath;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @Column(nullable = true)
    private String job;

    @Column(nullable = false)
    private String area;

    @Column(nullable = false)
    private boolean active;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp
    private Timestamp createDate;

    private String oauth;

    private String provider;
    private String providerId;

    // 나중에 지우기
    @Builder
    public User(String username, String password, String nickname, String email, Date birthday, String job, String area, RoleType role, String provider, String providerId) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.birthday = birthday;
        this.job = job;
        this.area = area;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}
