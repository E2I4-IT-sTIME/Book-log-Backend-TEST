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
@Builder
@Table(name="userinfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    private List<Portfolio> portfolio = new ArrayList<>();

    private List<Review> review = new ArrayList<>();

    private List<Meeting> meeting = new ArrayList<>();

    private int heart;

    @Column(nullable = false)
    @Size(min = 0, max= 100)
    private Long temperature;
}
