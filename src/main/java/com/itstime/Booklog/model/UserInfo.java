package com.itstime.Booklog.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    private Long user_id;

    private List<Portfolio> portfolios = new ArrayList<>();

    private List<Review> reviews = new ArrayList<>();

    private List<Meeting> meetings = new ArrayList<>();

    //private int heart;

//    @Column(nullable = false)
//    @Size(min = 0, max= 100)
//    private Long temperature;
}
