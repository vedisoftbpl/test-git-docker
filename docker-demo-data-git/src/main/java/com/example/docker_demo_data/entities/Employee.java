package com.example.docker_demo_data.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String empName;
	private String dept;
	private String desig;
	private Double salary;
	private LocalDate doj;

	public Employee() {
	}

	public Employee(Long empId, String empName, String dept, String desig, Double salary, LocalDate doj) {
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.desig = desig;
		this.salary = salary;
		this.doj = doj;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", dept=" + dept + ", desig=" + desig + ", salary="
				+ salary + ", doj=" + doj + "]";
	}

}
