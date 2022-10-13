package com.nissan.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//JPA specification to map this professor table in database

@Entity
@Table(name="Professor")
@NamedQueries({
	@NamedQuery(name="Professor.findByName",query="SELECT p FROM Professor p WHERE p.firstName=:name")
})
public class Professor {

	//declare fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int professorId;
	private int managerId;
	private String firstName;
	private String lastName;
	private int deptNo;
	private double salary;
	private LocalDate joinDate;
	private LocalDate dob;
	private String gender;
	
	//default Constructor
	public Professor() {
	}

	//parameterized constructor
	public Professor(int professorId,int managerId, String firstName, String lastName, int deptNo, double salary, LocalDate joinDate,
			LocalDate dob, String gender) {
		super();
		this.professorId = professorId;
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptNo = deptNo;
		this.salary = salary;
		this.joinDate = joinDate;
		this.dob = dob;
		this.gender = gender;
	}
	
	
	public Professor(int managerId, String firstName, String lastName, int deptNo, double salary, LocalDate joinDate,
			LocalDate dob, String gender) {
		super();
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptNo = deptNo;
		this.salary = salary;
		this.joinDate = joinDate;
		this.dob = dob;
		this.gender = gender;
	}

	//getters and setters
	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	//override to string
	
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", managerId=" + managerId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", deptNo=" + deptNo + ", salary=" + salary + ", joinDate=" + joinDate
				+ ", dob=" + dob + ", gender=" + gender + "]";
	}
}
