package com.arjunshaji.student.controller;

import com.arjunshaji.student.entity.Student;
import com.arjunshaji.student.service.StudentService;
import com.arjunshaji.student.vo.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stud")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Object saveStudent(@RequestBody Student student){
        log.info("INSIDE SAVE STUDENT METHOD OF STUDENT CONTROLLER");
        return studentService.saveStudent(student);
    }

    @GetMapping("/{deptCode}")
    public ArrayList<ResponseTemplate> getStudentWithDepartment(@PathVariable("deptCode") String code){
        log.info("INSIDE GET STUDENT WITH DEPARTMENT METHOD OF STUDENT CONTROLLER");
        return studentService.getStudentWithDepartment(code);
    }

}
