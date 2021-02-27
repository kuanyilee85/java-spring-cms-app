package com.kennycode.employee;

import com.kennycode.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeJpaResource {

    @Autowired
    private EmployeeHardcodedService employeeService;

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    // replaced with JPA/hibernate API in real case
    // READ / get all employee
    @GetMapping("/jpa/users/{username}/employees")
    public List<Employee> getAllEmployee(@PathVariable String username){
        return employeeJpaRepository.findByUsername(username);
//        return employeeService.findAll();
    }

    // READ / get specific employee
    @GetMapping("/jpa/users/{username}/employees/{id}")
    public Employee getEmployee(@PathVariable String username, @PathVariable long id){
        return employeeJpaRepository.findById(id).get();
//        return employeeService.findById(id);
    }

    // DELETE /users/{user_name}/employees/{id}
    @DeleteMapping("/jpa/users/{username}/employees/{id}")
    // ResponseEntity return http status code, etc.
    public ResponseEntity<Void> deleteEmployee(@PathVariable String username, @PathVariable long id) {
        Employee employee = employeeService.deleteById(id);

        if(employee != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Update an employee
    // PUT /users/{username}/employees/{id}
    @PutMapping("/jpa/users/{username}/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String username, @PathVariable long id, @RequestBody Employee employee) {
        Employee employeeUpdated = employeeService.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    // Create an employee
    // PUT /users/{username}/employees/{id}
    @PostMapping("/jpa/users/{username}/employees/")
    public ResponseEntity<Void> updateEmployee(@PathVariable String username, @RequestBody Employee employee) {
        Employee employeeCreated = employeeService.save(employee);

        // Location
        // Get current resource url
        // {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employeeCreated.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
