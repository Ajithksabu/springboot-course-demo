package com.springboot.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.springboot.demo.entities.Employee;
import com.springboot.demo.exceptions.UserAlreadyCreatedWithSameEmployeeCodeException;
import com.springboot.demo.exceptions.UserNotFoundException;
import com.springboot.demo.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {
        try {
            employeeService.addEmployee(employee);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

        } catch (UserAlreadyCreatedWithSameEmployeeCodeException ex) {
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, ex.getMessage());
        }
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
