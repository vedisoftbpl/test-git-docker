package com.example.docker_demo_data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.docker_demo_data.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}