package com.springboot.application.controller;

import com.springboot.application.exception.ResourceNotFountException;
import com.springboot.application.model.Employee;
import com.springboot.application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // get employee by id rest api
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = repository.findById(id).orElseThrow(() ->
            new ResourceNotFountException("Employee not exist with this id" + id));
        return ResponseEntity.ok(employee);
    }

    // update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emplDetail){
        Employee employee = repository.findById(id).orElseThrow(() ->
                new ResourceNotFountException("Employee not exist with this id" + id));
        employee.setFirstName(emplDetail.getFirstName());
        employee.setLastName(emplDetail.getLastName());
        employee.setEmail(emplDetail.getEmail());
       Employee updatedEmployee =  repository.save(employee);
       return ResponseEntity.ok(updatedEmployee);
    }

}
