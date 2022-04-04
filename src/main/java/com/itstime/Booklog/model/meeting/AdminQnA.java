package com.itstime.Booklog.model.meeting;


import com.itstime.Booklog.model.meeting.Meeting;
import com.itstime.Booklog.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin_qna")
public class AdminQnA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "admin_qna_id", cascade = CascadeType.ALL)
    private Meeting meeting_id;

    @ManyToOne
    private User user_id;

    @OneToOne(mappedBy = "admin_qna_id", cascade = CascadeType.ALL)
    private UserQnA user_qna;

    @Lob
    private String q1;

    @Lob
    private String q2;

    @Lob
    private String q3;
}
