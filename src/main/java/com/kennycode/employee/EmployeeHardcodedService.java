package com.kennycode.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeHardcodedService {
    private static List<Employee> employees = new ArrayList<>();
    private static long idCounter = 0;

    static {
        employees.add(new Employee(++idCounter, "admin", "Bruce", "Lee", "Body Guard", "Secret Service", new Date(), true, "Top secret"));
        employees.add(new Employee(++idCounter, "admin", "Michael", "Jackson", "Singer", "Secret Guest", new Date(), true, "Top secret"));
        employees.add(new Employee(++idCounter, "admin", "Jimmy", "John", "Chef", "Secret Kitchen", new Date(), true, "Top secret"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee save(Employee employee) {
        if(employee.getId() == -1 || employee.getId() == 0) {
            // CREATE; new data (id == -1) without id, set an id
            employee.setId(++idCounter);
            employees.add(employee);
        } else {
            // UPDATE; old data with id, delete then add
            deleteById(employee.getId());
            employees.add(employee);
        }
        return employee;
    }

    public Employee deleteById(long id) {
        Employee employee = findById(id);

        if(employee == null) return null;

        if(employees.remove(employee)) {
            return employee;
        }
        return null;
    }

    public Employee findById(long id) {
        for(Employee employee:employees) {
            if(employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
