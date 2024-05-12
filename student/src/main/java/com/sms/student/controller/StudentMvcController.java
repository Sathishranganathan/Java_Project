package com.sms.student.controller;

import com.sms.student.dto.StudentDTO;
import com.sms.student.service.StudentSrv;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class StudentMvcController {
    private StudentSrv studentSrv;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    /*@RequestMapping("/mvc/student/createStudent")
    public ResponseEntity<StudentDTO> createStudent (@RequestBody StudentDTO studentDTO) {
        //log.info("1");
        StudentDTO savedStudentDTO = studentSrv.createStudent(studentDTO);
        //log.info(savedStudentDTO.getId().toString());
        return new ResponseEntity<>(savedStudentDTO, HttpStatus.CREATED);
    }*/

    @GetMapping("/welcome")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        log.info("greeting method invoked");
        //model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String main(Model model) {
        log.info("Getting main method page");
        String message = "";
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        return "index"; //view
    }

    @RequestMapping(value="/getStudent", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<StudentDTO> getAllStudents() {
       //log.info("Getting all students method page");
        return studentSrv.getAllStudents();
    }

    @RequestMapping(value="/getStudentList", method = RequestMethod.GET, produces = "application/json")
    public String getAllStudentsList(Model model) {
        model.addAttribute("studentList", studentSrv.getAllStudents());
        return "studentList";
    }

}
