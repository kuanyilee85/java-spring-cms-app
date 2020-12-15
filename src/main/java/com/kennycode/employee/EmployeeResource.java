package com.kennycode.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {

    @Autowired
    private EmployeeHardcodedService employeeService;

    // in real case, replaced with JPA/hibernate API
    // get all employee
    @GetMapping("users/{username}/employees")
    public List<Employee> getAllEmployee(@PathVariable String username){
        return employeeService.findAll();
    }

    //get specific employee
    @GetMapping("users/{username}/employees/{id}")
    public Employee getEmployee(@PathVariable String username, @PathVariable long id){
        return employeeService.findById(id);
    }

    // DELETE /users/{user_name}/employees/{id}
    @DeleteMapping("/users/{username}/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String username, @PathVariable long id) {
        Employee employee = employeeService.deleteById(id);

        if(employee != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
