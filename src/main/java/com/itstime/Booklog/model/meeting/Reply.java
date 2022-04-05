package com.itstime.Booklog.model.meeting;


import com.itstime.Booklog.model.user.User;
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
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meetingBoard_id")
    private Meeting_board meetingBoard;

    @ManyToOne
    private User user;

    @Lob
    private String text;

    @CreationTimestamp
    private Timestamp timestamp;
}
