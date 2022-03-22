package com.springboot.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.springboot.demo.entities.Employee;
import com.springboot.demo.exceptions.UserNotFoundException;
import com.springboot.demo.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    @GetMapping("/employee/byBranchName/{branch}")
    public Optional<Employee> getEmployeeByBranch(@PathVariable("branch") String branch) {
        return employeeService.getEmployeeByBranch(branch);
    }
}
