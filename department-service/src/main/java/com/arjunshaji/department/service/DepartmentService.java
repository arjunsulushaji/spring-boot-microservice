package com.arjunshaji.department.service;

import com.arjunshaji.department.entity.Department;
import com.arjunshaji.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Object saveDepartment(Department department) {
        log.info("INSIDE SAVE DEPARTMENT METHOD OF DEPARTMENT SERVICE");
        return departmentRepository.save(department);
    }

    public Object findDepartmentById(Long id) {
        log.info("INSIDE FIND DEPARTMENT BY ID METHOD OF DEPARTMENT SERVICE");
        return departmentRepository.findById(id);
    }

    public Department findByDeptCode(String code) {
        log.info("INSIDE FIND DEPARTMENT BY CODE METHOD OF DEPARTMENT SERVICE");
        return departmentRepository.findByDeptCode(code);
    }
}
