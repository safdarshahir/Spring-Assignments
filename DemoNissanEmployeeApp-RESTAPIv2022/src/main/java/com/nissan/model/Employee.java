package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TblEmployee")
public class Employee {

	//Declare fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	@Column(nullable=false)
	private String empName;
	private String designation;
	private LocalDate dateOfJoining;
	private double salary;
	private String empPhoneNumber;
	private Boolean isActive;
	
	@JoinColumn(name="deptId")
	@ManyToOne
	private Department department;

	//Default Constructor
	public Employee() {
		super();
	}

	//Parameterized Constructor
	public Employee(int empId, String empName, String designation, LocalDate dateOfJoining, double salary,
			String empPhoneNumber,Boolean isActive,
			Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
		this.empPhoneNumber = empPhoneNumber;
		this.isActive = isActive;
		this.department = department;
	}

	//getters and setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public String getEmpPhoneNumber() {
		return empPhoneNumber;
	}

	public void setEmpPhoneNumber(String empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}
	

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	//Override toString()
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", dateOfJoining="
				+ dateOfJoining + ", salary=" + salary + ", department=" + department + "]";
	}

}
