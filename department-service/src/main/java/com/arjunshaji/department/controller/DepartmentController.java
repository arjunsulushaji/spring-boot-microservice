package com.arjunshaji.department.controller;

import com.arjunshaji.department.entity.Department;
import com.arjunshaji.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Object saveDepartment(@RequestBody Department department){
        log.info("INSIDE SAVE DEPARTMENT METHOD OF DEPARTMENT CONTROLLER");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Object findDepartmentById(@PathVariable Long id){
        log.info("INSIDE FIND DEPARTMENT BY ID METHOD OF DEPARTMENT CONTROLLER");
        return departmentService.findDepartmentById(id);
    }

    @GetMapping("/code/{code}")
    public Department findByDeptCode(@PathVariable String code){
        log.info("INSIDE FIND DEPARTMENT BY CODE METHOD OF DEPARTMENT CONTROLLER");
        return departmentService.findByDeptCode(code);
    }
}
