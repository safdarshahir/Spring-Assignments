package com.nissan.service;

import java.util.List;

import com.nissan.model.Employee;

public interface IEmployeeService{
	
	//List all employees
	List<Employee> listAllEmployees();
	
	//Add an employee
	Employee addEmployee(Employee emp);
	
	//Edit an employee
	Employee editEmployee(Employee emp);
	
	//Delete an employee
	Employee deleteEmployee(Employee emp);
	
//	//Search an employee by phone
	Employee searchByPhone(String empPhoneNumber);
}
