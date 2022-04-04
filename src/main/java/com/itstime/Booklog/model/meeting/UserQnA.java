package com.itstime.Booklog.model.meeting;


import com.itstime.Booklog.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_qna")
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

    @OneToOne
    @JoinColumn(name = "admin_qna_id")
    private AdminQnA admin_qna_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

}
