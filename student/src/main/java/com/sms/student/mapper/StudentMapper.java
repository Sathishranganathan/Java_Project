package com.sms.student.mapper;

import com.sms.student.dto.StudentDTO;
import com.sms.student.model.Student;

public class StudentMapper {

    //log.info("Model to DTO");
    public static StudentDTO mapToStudentDTO(Student student) {
        return StudentDTO.builder().id(student.getId()).name(student.getName())
                .gender(student.getGender()).dob(student.getDob()).std(student.getStd()).build();
    }

    //log.info("DTO to Model");
    public static Student mapToStudent(StudentDTO studentDTO) {
        return Student.builder().id(studentDTO.getId()).name(studentDTO.getName())
                .gender(studentDTO.getGender()).dob(studentDTO.getDob()).std(studentDTO.getStd()).build();
    }

}
