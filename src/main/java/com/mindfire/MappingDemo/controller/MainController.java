package com.mindfire.MappingDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindfire.MappingDemo.model.Department;
import com.mindfire.MappingDemo.model.Employee;
import com.mindfire.MappingDemo.repository.DepartmentRepository;
import com.mindfire.MappingDemo.repository.EmployeeRepository;

@RestController
public class MainController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@RequestMapping("/api/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees = (List<Employee>) employeeRepository.findAll();
		return employees;
	}
	
	@RequestMapping("/api/departments")
	public List<Department> getDepartments() {
		List<Department> departments = new ArrayList<>();
		departments = (List<Department>) departmentRepository.findAll();
		return departments;
	}

}
