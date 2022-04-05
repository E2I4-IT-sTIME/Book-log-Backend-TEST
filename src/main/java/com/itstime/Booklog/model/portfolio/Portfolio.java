package com.itstime.Booklog.model.portfolio;

import com.itstime.Booklog.model.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "portfolio")
public class Portfolio {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userInfo_id")
    private UserInfo userInfo;

    @ManyToMany
    @JoinTable(name = "portfolio_reviews", joinColumns = @JoinColumn(name = "portfolio_id"), inverseJoinColumns = @JoinColumn(name = "review_id"))
    private List<Review> reviews;

    private String title;
}
