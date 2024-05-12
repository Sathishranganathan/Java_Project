package com.sms.student.service;

import com.sms.student.dto.StudentDTO;

import java.util.List;

public interface StudentSrv {
 StudentDTO createStudent(StudentDTO studentDTO);
 StudentDTO updateStudent(StudentDTO studentDTO);
 StudentDTO deleteStudent(StudentDTO studentDTO);
 void deleteStudentByID(Long id);
 StudentDTO getStudentByID(Long id);
 List<StudentDTO> getAllStudents();
}
