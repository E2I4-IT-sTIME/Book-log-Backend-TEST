package com.itstime.Booklog.model.user;


import com.itstime.Booklog.model.meeting.Meeting;
import com.itstime.Booklog.model.portfolio.Portfolio;
import com.itstime.Booklog.model.portfolio.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="userinfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @OneToMany(mappedBy = "userInfo_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Portfolio> portfolios = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Meeting> meetings = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Meeting> admin_meetings = new ArrayList<>();

    //private int heart;

//    @Column(nullable = false)
//    @Size(min = 0, max= 100)
//    private Long temperature;
}
