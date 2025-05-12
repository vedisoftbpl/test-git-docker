package com.example.docker_demo_data.services;

import java.util.List;

import com.example.docker_demo_data.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Long id, Employee employee);

	Employee patchEmployee(Long id, Employee employee);

	boolean deleteEmployee(Long id);
}
