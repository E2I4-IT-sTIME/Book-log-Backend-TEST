package com.itstime.Booklog.model.meeting;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meeting_board")
public class Meeting_board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @OneToMany(mappedBy = "meetingBoard", cascade = CascadeType.ALL)
    private List<Reply> replys;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Lob
    private String content;

    @Column(nullable = false)
    private int notice;

    @CreationTimestamp
    private Timestamp createDate;
}
