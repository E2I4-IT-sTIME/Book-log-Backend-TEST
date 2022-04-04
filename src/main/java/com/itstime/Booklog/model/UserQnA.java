package com.itstime.Booklog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userQnA")
public class UserQnA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String a1;

    @Lob
    private String a2;

    @Lob
    private String a3;

    @Column(nullable = false)
    private Long adminQnA_id;

    @Column(nullable = false)
    private Long user_id;

}
