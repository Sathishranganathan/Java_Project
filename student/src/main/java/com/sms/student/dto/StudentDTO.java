package com.sms.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentDTO {

    private Long id;

    private String name;
    
    private LocalDate dob;

   private String gender;

    private String std;
}
