package com.itstime.Booklog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meeting_board")
public class Meeting_board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long meeting_id;

    @Column(nullable = false)
    private Long reply_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean onoff;

    private int maximum;

    @CreationTimestamp
    private Timestamp timestamp;

}
