package com.springboot.application.controller;

import com.springboot.application.model.Employee;
import com.springboot.application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // GET all employee

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }

    // Create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }

}
