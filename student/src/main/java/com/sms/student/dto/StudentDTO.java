package com.sms.student.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentDTO {

    private Long id;

    private String name;

    //private Date dob;

    private String dob;

    private String gender;

    private String std;
}
