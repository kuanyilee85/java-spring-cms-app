package com.kennycode;

import com.kennycode.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByUsername(String username);
}
