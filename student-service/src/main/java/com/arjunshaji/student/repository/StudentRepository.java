package com.arjunshaji.student.repository;

import com.arjunshaji.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //Student findByDeptCode(String deptCode);

    ArrayList<Student> findByDeptCode(String deptCode);
}
