package com.itstime.Booklog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "givechange")
public class GiveChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "책 이름은 2자이상 30자 이하여야 합니다.")
    private String name;

    private User seller;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String area;

    @CreationTimestamp
    private Timestamp createDate;
}
