package com.itstime.Booklog.model.meeting;

import com.itstime.Booklog.model.user.User;
import com.itstime.Booklog.model.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "admin_qna_id")
    private AdminQnA admin_qna_id;

    @ManyToOne
    @JoinColumn(name = "userInfo_id")
    private UserInfo userInfo_id; // admin

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "meeting_id", cascade = CascadeType.ALL)
    private Meeting_board meeting_board;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    private List<User> users = new ArrayList<>();

    @Column(nullable = false)
    private int method; // online=1, offline=0

    @Column(nullable = false)
    private int max_users;

    @CreationTimestamp
    private Timestamp createDate;
}
