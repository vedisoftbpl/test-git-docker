package com.example.docker_demo_data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.docker_demo_data.entities.Employee;
import com.example.docker_demo_data.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee updateEmployee(Long id, Employee updated) {
		Optional<Employee> optional = repository.findById(id);
		if (optional.isPresent()) {
			Employee existing = optional.get();
			existing.setEmpName(updated.getEmpName());
			existing.setDept(updated.getDept());
			existing.setDesig(updated.getDesig());
			existing.setSalary(updated.getSalary());
			existing.setDoj(updated.getDoj());
			return repository.save(existing);
		}
		return null;
	}

	@Override
	public Employee patchEmployee(Long id, Employee patch) {
		Optional<Employee> optional = repository.findById(id);
		if (optional.isPresent()) {
			Employee existing = optional.get();

			if (patch.getEmpName() != null) {
				existing.setEmpName(patch.getEmpName());
			}
			if (patch.getDept() != null) {
				existing.setDept(patch.getDept());
			}
			if (patch.getDesig() != null) {
				existing.setDesig(patch.getDesig());
			}
			if (patch.getSalary() != null) {
				existing.setSalary(patch.getSalary());
			}
			if (patch.getDoj() != null) {
				existing.setDoj(patch.getDoj());
			}
			return repository.save(existing);
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
