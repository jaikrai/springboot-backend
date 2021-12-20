package com.springboot.application.controller;

import com.springboot.application.model.Employee;
import com.springboot.application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // GET all employee

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }
}
