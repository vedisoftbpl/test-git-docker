package com.example.docker_demo_data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.docker_demo_data.entities.Employee;
import com.example.docker_demo_data.services.EmployeeService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService service;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee employee = service.getEmployeeById(id);
		if (employee != null) {
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee saved = service.createEmployee(employee);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.location(URI.create("/api/employees/" + saved.getEmpId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee newEmp) {
		Employee updated = service.updateEmployee(id, newEmp);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Employee> patchEmployee(@PathVariable Long id, @RequestBody Employee patch) {
		Employee updated = service.patchEmployee(id, patch);
		if (updated != null) {
			return ResponseEntity.status(HttpStatus.OK).body(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		boolean deleted = service.deleteEmployee(id);
		if (deleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
