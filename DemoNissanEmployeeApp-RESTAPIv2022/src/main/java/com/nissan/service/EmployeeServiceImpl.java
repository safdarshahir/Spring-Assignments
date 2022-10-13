package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Employee;
import com.nissan.repo.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeRepository empRepo;
	
	@Override
	public List<Employee> listAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	@Transactional
	public Employee editEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	

	@Override
	public Employee searchByPhone(String empPhoneNumber) {
		Employee emp = empRepo.searchByPhoneNumber(empPhoneNumber);
		if(empPhoneNumber.equals(emp.getEmpPhoneNumber()) && emp.getIsActive()) {
			return emp;
		}else {
			return null;
		}
	}

	@Override
	@Transactional
	public Employee deleteEmployee(Employee emp) {
		emp.setIsActive(false);
		return empRepo.save(emp);
	}

}
