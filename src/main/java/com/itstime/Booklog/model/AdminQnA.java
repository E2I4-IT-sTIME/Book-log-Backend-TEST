package com.itstime.Booklog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adminQnA")
public class AdminQnA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long meeting_id;

    @Column(nullable = false)
    private Long user_id;

    @Lob
    private String q1;

    @Lob
    private String q2;

    @Lob
    private String q3;
}
