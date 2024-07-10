package com.employee.spring.jdbc.Employee_Spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.employee.spring.jdbc.Employee_Spring.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
