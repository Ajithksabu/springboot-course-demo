package com.springboot.demo.repositiories;

import java.util.Optional;

import com.springboot.demo.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByBranch(String branch);
    Optional<Employee> findByEmployeeCode(String employeeCode);
}
