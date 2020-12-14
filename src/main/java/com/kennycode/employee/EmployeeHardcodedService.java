package com.kennycode.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeHardcodedService {
    private static List<Employee> employees = new ArrayList<>();
    private static int idCounter = 0;

    static {
        employees.add(new Employee(++idCounter, "Bruce", "Lee", "Body Guard", "Secret Service", new Date(), true, "Top secret"));
        employees.add(new Employee(++idCounter, "Michael", "Jackson", "Singer", "Secret Guest", new Date(), true, "Top secret"));
        employees.add(new Employee(++idCounter, "Jimmy", "John", "Chef", "Secret Kitchen", new Date(), true, "Top secret"));
    }

    public List<Employee> findAll() {
        return employees;
    }
}
