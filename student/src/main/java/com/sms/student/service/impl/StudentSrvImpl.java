package com.sms.student.service.impl;

import com.sms.student.dto.StudentDTO;
import com.sms.student.model.Student;
import com.sms.student.repository.StudentRepository;
import com.sms.student.service.StudentSrv;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j

public class StudentSrvImpl implements StudentSrv {

    private StudentRepository studentRepository;

    /**
     * @param studentDTO
     * @return
     */
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = Student.builder().name(studentDTO.getName())
                .dob(studentDTO.getDob()).gender(studentDTO.getGender()).std(studentDTO.getStd()).build();
        studentRepository.save(student);
        log.info("Record {} {} created successfully 1", student.getId(), student.getName());
        studentDTO.setId(student.getId());
        return studentDTO;
    }

    /**
     * @param studentDTO
     * @return
     */
    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        return null;
    }

    /**
     * @param studentDTO
     * @return
     */
    @Override
    public StudentDTO deleteStudent(StudentDTO studentDTO) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public StudentDTO getStudentByID(Long id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<StudentDTO> getAllStudents() {
       // log.info("1");
        List<Student> students = studentRepository.findAll();
       // log.info("2 {} ", students);
        return students.stream().map(this::mapToStudentDTO).toList();
    }

    private StudentDTO mapToStudentDTO(Student student) {
        //log.info("MTS 1");
        return StudentDTO.builder().id(student.getId()).name(student.getName())
                .gender(student.getGender()).dob(student.getDob()).std(student.getStd()).build();
    }
}
