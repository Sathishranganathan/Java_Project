package com.sms.student.controller;

import com.sms.student.dto.StudentDTO;
import com.sms.student.service.StudentSrv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class StudentCtlr {
    private StudentSrv studentSrv;

    public ResponseEntity<StudentDTO> createStudent (@RequestBody StudentDTO studentDTO) {
        //log.info("1");
        StudentDTO savedStudentDTO = studentSrv.createStudent(studentDTO);
        //log.info(savedStudentDTO.getId().toString());
        return new ResponseEntity<>(savedStudentDTO, HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getAllStudents() {
        return studentSrv.getAllStudents();

    }

}
