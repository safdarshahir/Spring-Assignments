package com.nissan.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.nissan.model.Professor;


public class CredRepositoryImpl implements ICredRepository {
	public void insertEntity() {
		
		
		EntityManagerFactory emf=null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input = new Scanner(System.in);
		
		//start process
		try {
			//EntityManagerFactory
			
			emf = Persistence.createEntityManagerFactory("DemoProfessor");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			//start transaction
			transaction.begin();
			
			//create an object for input
			
			Professor professor = new Professor();
			
			//get input from the user
			
			System.out.print("Enter First name:");
			professor.setFirstName(input.nextLine());
			
			System.out.print("Enter Last name:");
			professor.setLastName(input.nextLine());
			
			System.out.print("Enter Department No:");
			professor.setDeptNo(Integer.parseInt(input.nextLine()));
			
			System.out.print("Enter Salary:");
			professor.setSalary(Double.parseDouble(input.nextLine()));
			
			System.out.print("Enter Joining Date (yyyy-mm-dd):");
			professor.setJoinDate(LocalDate.parse(input.nextLine()));
			
			System.out.print("Enter Date of Birt (yyyy-mm-dd):");
			professor.setDob(LocalDate.parse(input.nextLine()));
			
			System.out.print("Enter Gender:");
			professor.setGender(input.nextLine());
			
			// here data into ORM
			entityManager.persist(professor);
			
			// here data into database
			transaction.commit();
				
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			System.out.println(emf);

			emf.close();
		}

	}

	public void listAllProcessors() {


		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		Scanner input = new Scanner(System.in);
		
		//start process
		try {
			//EntityManagerFactory
			
			emf = Persistence.createEntityManagerFactory("DemoProfessor");
			entityManager = emf.createEntityManager();
			
	
			List<Professor> professors = (List<Professor>) entityManager.createQuery("from DemoProfessor");
			for(Professor professor:professors) {
				System.out.println("ProfessorId: "+professor.getProfessorId());
				System.out.println("First Name: "+professor.getFirstName());
				System.out.println("Last Name: "+professor.getLastName());
				System.out.println("DeptNo : "+professor.getDeptNo());
				System.out.println("Salary :"+professor.getSalary());
				System.out.println("Date of Birth : "+professor.getDob());
				System.out.println("Gender :"+professor.getGender());
			}
		} catch (Exception e) {
		}finally {
			emf.close();
		}
	}

	public void editProfessor() {


		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input = new Scanner(System.in);
		
		//start process
		try {
			//EntityManagerFactory
			
			emf = Persistence.createEntityManagerFactory("DemoProfessor");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			//start transaction
			transaction.begin();
			
			//create an object for input
			
			System.out.print("Enter the id:");
			int id = Integer.parseInt(input.nextLine());
			
			Professor professor = entityManager.find(Professor.class, id);
			
			System.out.print("Enter new First Name:");
			professor.setFirstName(input.nextLine());
			
			System.out.print("Enter new Last Name:");
			professor.setLastName(input.nextLine());
			
			// here data into ORM
			entityManager.getTransaction().commit();
	
				
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			emf.close();
		}

	}

	public void deleteProfessor() {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input = new Scanner(System.in);
		
		//start process
		try {
			//EntityManagerFactory
			
			emf = Persistence.createEntityManagerFactory("DemoProfessor");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			//start transaction
			transaction.begin();
			
			
			System.out.print("Enter the id:");
			int id = Integer.parseInt(input.nextLine());
			
			Professor professor = entityManager.find(Professor.class, id);
			
			entityManager.remove(professor);
			
			entityManager.getTransaction().commit();
			
			System.out.println(professor+" Deleted...");
			
				
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			emf.close();
		}
	}

	public Optional<Professor> findByName(String name) {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		
		
		//start process
		try {
			//EntityManagerFactory
			
			emf = Persistence.createEntityManagerFactory("DemoProfessor");
			entityManager = emf.createEntityManager();
			
			Professor professor = entityManager.createQuery("SELECT p FROM Professor p WHERE p.firstName=:name",Professor.class)
					.setParameter("firstName", name)
					.getSingleResult();
	
			return (Optional<Professor>) (professor != null ? Optional.of(professor):Optional.empty());
		} catch (Exception e) {
		}finally {
			emf.close();
		}
		return null;
	}

	public void searchById() {


		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input = new Scanner(System.in);
		
		//start process
		try {
			//EntityManagerFactory
			
			emf = Persistence.createEntityManagerFactory("DemoProfessor");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			//start transaction
			transaction.begin();
			
			//create an object for input
			
			System.out.print("Enter the id:");
			int id = Integer.parseInt(input.nextLine());
			
			Professor professor = entityManager.find(Professor.class, id);
			
			System.out.println("ProfessorId: "+professor.getProfessorId());
			System.out.println("First Name: "+professor.getFirstName());
			System.out.println("Last Name: "+professor.getLastName());
			System.out.println("DeptNo : "+professor.getDeptNo());
			System.out.println("Salary :"+professor.getSalary());
			System.out.println("Date of Birth : "+professor.getDob());
			System.out.println("Gender :"+professor.getGender());
	
				
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			emf.close();
		}
	}

}
