package com.springboot.demo.services;

import java.util.List;
import java.util.Optional;

import com.springboot.demo.entities.Employee;
import com.springboot.demo.exceptions.UserAlreadyCreatedWithSameEmployeeCodeException;
import com.springboot.demo.exceptions.UserNotFoundException;
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

    public void addEmployee(Employee employee) throws UserAlreadyCreatedWithSameEmployeeCodeException {
        Optional<Employee> optionalEmployee = employeeRepostory.findByEmployeeCode(employee.getEmployeeCode());
        if (optionalEmployee.isPresent()) {
            throw new UserAlreadyCreatedWithSameEmployeeCodeException("User with same employee code already exist");
        }
        employeeRepostory.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) throws UserNotFoundException {
        Optional<Employee> employee = employeeRepostory.findById(id);
        if (!employee.isPresent()) {
            throw new UserNotFoundException("User not found in the db for the id " + id);
        }

        return employee;
    }

    public Optional<Employee> getEmployeeByBranch(String branch) {
        return employeeRepostory.findByBranch(branch);
    }
}
