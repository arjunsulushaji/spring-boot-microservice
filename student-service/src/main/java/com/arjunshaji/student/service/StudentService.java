package com.arjunshaji.student.service;

import com.arjunshaji.student.entity.Student;
import com.arjunshaji.student.repository.StudentRepository;
import com.arjunshaji.student.vo.Department;
import com.arjunshaji.student.vo.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Object saveStudent(Student student) {
        log.info("INSIDE SAVE STUDENT METHOD OF STUDENT SERVICE");
        return studentRepository.save(student);
    }

    public ArrayList<ResponseTemplate> getStudentWithDepartment(String code) {
        log.info("INSIDE GET STUDENT WITH DEPARTMENT METHOD OF STUDENT SERVICE");
        ArrayList<ResponseTemplate> vo = new ArrayList<>();
        ArrayList<Student> students =  studentRepository.findByDeptCode(code);
        Department department = restTemplate.getForObject("http://localhost:7777/dept/code/" + code, Department.class);
        for(Student student : students) {
            ResponseTemplate template = new ResponseTemplate();
            template.setDepartment(department);
            template.setStudent(student);
            vo.add(template);
        }
        return vo;
    }

}
