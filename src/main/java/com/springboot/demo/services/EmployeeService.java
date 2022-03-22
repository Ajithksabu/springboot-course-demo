package com.springboot.demo.services;

import java.util.List;
import java.util.Optional;

import com.springboot.demo.entities.Employee;
import com.springboot.demo.repositiories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepostory;

    public List<Employee> getAllEmployees() {
        return employeeRepostory.findAll();
    }

    public void addEmployee(Employee employee) {
        System.out.println("AKS");
        employeeRepostory.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepostory.findById(id);
    }

    public Optional<Employee> getEmployeeByBranch(String branch) {
        return employeeRepostory.findByBranch(branch);
    }
}
