package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Employee;
import com.nissan.service.IEmployeeService;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class UserController {
	
	@Autowired
	IEmployeeService empService;
	
	@GetMapping("employees")
	public List<Employee> listEmployee() {
		return empService.listAllEmployees();
	}
	
	@PostMapping("employees/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println("Adding Employee");
		return empService.addEmployee(emp);
	}
	
	@PutMapping("employees/edit")
	public Employee editEmployee(@RequestBody Employee emp) {
		System.out.println("Editing Employee");
		return empService.editEmployee(emp);
	}
	
	@PutMapping("employees/disable")
	public Employee deleteEmployee(@RequestBody Employee emp) {
		return empService.deleteEmployee(emp);
	}
	

	
	@GetMapping("employees/search/{empPhoneNumber}")
	public Employee searchByPhone(@PathVariable String empPhoneNumber){
		return empService.searchByPhone(empPhoneNumber);
	}

}
