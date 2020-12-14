package com.kennycode.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {

    @Autowired
    private EmployeeHardcodedService employeeService;

    // in real case, replaced with JPA/hibernate API
    @GetMapping("users/{username}/employees")
    public List<Employee> getAllEmployees(@PathVariable String username){
        return employeeService.findAll();
    }
}
