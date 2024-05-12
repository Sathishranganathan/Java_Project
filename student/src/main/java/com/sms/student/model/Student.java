package com.sms.student.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    /*@Column(name="DoB", columnDefinition ="DATE")
    private Date dob;*/

    @Column(name="DoB")
    private String dob;

    @Column(name="gender", nullable=false)
    private String gender;

    @Column(name="standard", nullable=false)
    private String std;

}
