package com.sms.student.controller;

import com.sms.student.dto.StudentDTO;
import com.sms.student.service.StudentSrv;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
@Slf4j
public class StudentAPICtlr {
    private StudentSrv studentSrv;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent (@RequestBody StudentDTO studentDTO) {
        //log.info("1");
        StudentDTO savedStudentDTO = studentSrv.createStudent(studentDTO);
        //log.info(savedStudentDTO.getId().toString());
        return new ResponseEntity<>(savedStudentDTO, HttpStatus.CREATED);
    }

    /*public ResponseEntity<StudentDTO> createStudent (@RequestBody StudentDTO studentDTO) {
        return super.createStudent(studentDTO);
    }*/

    @GetMapping
    @ResponseStatus (HttpStatus.OK)
    public List<StudentDTO> getAllStudents() {
        return studentSrv.getAllStudents();

    }


}
