package com.springboot.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50, nullable = false, unique = false)
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Column(length = 50, nullable = false, unique = false)
    private Integer age;
    @Column(name = "employee_code", length = 50, nullable = false, unique = true)
    private String employeeCode;
    @Column(length = 50, nullable = true, unique = false)
    private String branch;

    public Employee() {
    }

    public Employee(Long id, String name, Integer age, String employeeCode, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.employeeCode = employeeCode;
        this.branch = branch;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmployeeCode() {
        return this.employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                ", employeeCode='" + getEmployeeCode() + "'" +
                ", branch='" + getBranch() + "'" +
                "}";
    }

}
