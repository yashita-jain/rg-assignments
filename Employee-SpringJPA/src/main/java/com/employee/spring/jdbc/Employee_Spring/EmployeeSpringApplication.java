package com.employee.spring.jdbc.Employee_Spring;

import com.employee.spring.jdbc.Employee_Spring.model.Employee;
import com.employee.spring.jdbc.Employee_Spring.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeSpringApplication.class, args);

		Employee employee = new Employee();
		employee.setId(1007);
		employee.setName("Yashita Jain");
		employee.setDepartment("Debit Card");

		Employee employee2 = new Employee();
		employee2.setId(1009);
		employee2.setName("Employee 2 ");
		employee2.setDepartment("Savings");


		Employee employee3 = new Employee();
		employee3.setId(1010);
		employee3.setName("Employee 3");
		employee3.setDepartment("Credit Card");

		EmployeeRepository repo = context.getBean(EmployeeRepository.class);
		// create
		repo.save(employee);
		repo.save(employee2);
		repo.save(employee3);

		//read
		System.out.println(repo.findAll());

		employee.setDepartment("Wallet");
		//update
		repo.save(employee);
		//test
		System.out.println(repo.findAll());

		//delete
		repo.deleteById(employee3.getId());
		//test
		System.out.println(repo.findAll());

		//delete rest
		repo.deleteById(employee.getId());
		repo.deleteById(employee2.getId());
	}

}
