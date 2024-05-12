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
        log.info("save method invoked");
       /* Student student = Student.builder().name(studentDTO.getName())
                .dob(studentDTO.getDob()).gender(studentDTO.getGender()).std(studentDTO.getStd()).build();
        studentRepository.save(student);
        log.info("Record {} {} created successfully 1", student.getId(), student.getName());
        studentDTO.setId(student.getId());
        return studentDTO;

*/

        Student existingstudent  = studentRepository.findStudentByName(studentDTO.getName());

        if (existingstudent == null) {
            Student student = Student.builder().name(studentDTO.getName())
                    .dob(studentDTO.getDob()).gender(studentDTO.getGender()).std(studentDTO.getStd()).build();
            studentRepository.save(student);
            log.info("Record {} {} created successfully 1", student.getId(), student.getName());
            studentDTO.setId(student.getId());
            return "Customer added successfully";
        }
        else
            throw new CustomerAlreadyExistsException("Customer already exists!!");
        return studentDTO;
    }

    /**
     * @param studentDTO
     * @return
     */
    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Student student = EmployeeMapper.mapToEmployee(studentDTO);
        studentRepository.save(student);
        return  this.mapToStudentDTO(employee);
    }

    /**
     * @param studentDTO
     * @return
     */
    @Override
    public StudentDTO deleteStudent(StudentDTO studentDTO) {

        log.info("delete Student Id method invoked");
        studentRepository.deleteById(studentDTO.getId());
        return "Student DELETED successfully";
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
        return this.mapToStudentDTO(student);
    }

    /**
     * @return
     */
    @Override
    public List<StudentDTO> getAllStudents() {
        log.info("getAllStudents method invoked");
        List<Student> students = studentRepository.findAll();
        log.info("getAllEmployee total : {} ",students.size());
        return students.stream().map(this::mapToStudentDTO).toList();


    }

    private StudentDTO mapToStudentDTO(Student student) {
        //log.info("MTS 1");
        return StudentDTO.builder().id(student.getId()).name(student.getName())
                .gender(student.getGender()).dob(student.getDob()).std(student.getStd()).build();
    }




}
