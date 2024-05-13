package com.sms.student.controller;

import com.sms.student.dto.StudentDTO;
import com.sms.student.exception.ResourceNotFoundException;
import com.sms.student.service.StudentSrv;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("sms")

public class StudentMvcController {
    private StudentSrv studentSrv;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        log.info("viewHomePage method invoked");
        List<StudentDTO> studentDtoList = studentSrv.getAllStudents();
        //log.info("studentDtoList size is {} ",studentDtoList.size());
        model.addAttribute("studentList", studentDtoList);
        return "studentList";
    }

    @GetMapping("/viewStudent/{id}")
    public String viewStudent(@PathVariable(value = "id") long id, Model model) {
        log.info("viewStudent method invoked");
        StudentDTO studentDTO;
        try {
            studentDTO = studentSrv.getStudentByID(id);
            model.addAttribute("studentDTO", studentDTO);
            log.info("viewStudent {} ", studentDTO.getStd());
            //throw new NullPointerException("Data not found");
        } catch (ResourceNotFoundException e) {
            model.addAttribute("exception", e.getMessage());
            throw new ResourceNotFoundException(e.getMessage());
        }

        return "update";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        log.info("addNewStudent method invoked");
        model.addAttribute("studentDTO", new StudentDTO());
        return "newstudent";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("studentDTO") StudentDTO studentDTO) {
        log.info("saveStudent method invoked");
        studentSrv.createStudent(studentDTO);
        return "redirect:/sms/";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("studentDTO") StudentDTO studentDTO) {
        log.info("updateStudent method invoked");
        studentSrv.updateStudent(studentDTO);
        return "redirect:/sms/";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        log.info("deleteThroughId method invoked");
        try {
            studentSrv.deleteStudentByID(id);
            //throw new NullPointerException("Data not found");
        } catch (ResourceNotFoundException e) {
            //model.addAttribute("exception", e.getMessage());
            throw new ResourceNotFoundException(e.getMessage());
        }
        return "redirect:/sms/";
    }

}
