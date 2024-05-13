package com.sms.student.service.impl;

import com.sms.student.dto.StudentDTO;
import com.sms.student.exception.CustomerAlreadyExistsException;
import com.sms.student.exception.ResourceNotFoundException;
import com.sms.student.model.Student;
import com.sms.student.repository.StudentRepository;
import com.sms.student.service.StudentSrv;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


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
        log.info("save method invoked");
        Student existingstudent  = studentRepository.findStudentByName(studentDTO.getName());
        if (existingstudent == null) {
            Student student = mapToStudent(studentDTO);
            studentRepository.save(student);
            log.info("Record {} {} created successfully 1", student.getId(), student.getName());
            studentDTO.setId(student.getId());
            //return "Customer added successfully";
        }
        else
            throw new CustomerAlreadyExistsException("Customer already exists!!");
        return studentDTO;

    }

    /**
     * @param id
     * @return
     */
    @Override
    public StudentDTO getStudentByID(Long id) {

        log.info("getStudentByID method invoked");
        Student student  = studentRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Student is not found for the given id" + id));
        log.info("getStudentByID method end");
        return this.mapToStudentDTO(student);
    }

    /**
     * @return
     */
    @Override
    public List<StudentDTO> getAllStudents() {
        log.info("getAllStudents method invoked");
        List<Student> students = studentRepository.findAll();
        log.info("getAllStudents total : {} ",students.size());
        return students.stream().map(this::mapToStudentDTO).toList();
    }

    /**
     * @param studentDTO
     * @return
     */
    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student student = this.mapToStudent(studentDTO);
        studentRepository.save(student);
        return  this.mapToStudentDTO(student);

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
    public void deleteStudentByID(Long id) {
        studentRepository.deleteById(id);
    }


    //log.info("Model to DTO");
    public StudentDTO mapToStudentDTO(Student student) {
        log.info("mapToStudentDTO {} ",student.getDob());
         

        return StudentDTO.builder().id(student.getId()).name(student.getName())
                .gender(student.getGender()).dob(student.getDob()).std(student.getStd()).build();
    }

    //log.info("DTO to Model");
    public Student mapToStudent(StudentDTO studentDTO) {
        log.info("mapToStudent {} ",studentDTO.getDob());
        
       
        return Student.builder().id(studentDTO.getId()).name(studentDTO.getName())
                .gender(studentDTO.getGender()).dob(studentDTO.getDob()).std(studentDTO.getStd()).build();
    }
}

