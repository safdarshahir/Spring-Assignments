package com.nissan.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nissan.model.User;

public class CrudRepoImpl implements ICrudRepo {

	//Method to add new user
	public void addUser() {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input = new Scanner(System.in);
		
		try {
			
			emf = Persistence.createEntityManagerFactory("UserDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			entityManager.clear();
			//Start transaction
			transaction.begin();
			
			User userObj = new User();
			
			//get input from the user
			
			System.out.print("Enter User name:");
			userObj.setUserName(input.nextLine());
			
			System.out.print("Enter password:");
			userObj.setUserPassword(input.nextLine());
			
			System.out.print("Enter Role \n 1. Admin \n 2. User \n 3. Coordinator \n Enter choice:");
			int choice = Integer.parseInt(input.nextLine());
			switch (choice) {
				case 1:
					userObj.setRoleId("admin");
					break;
				case 2:
					userObj.setRoleId("user");
					break;
				case 3:					
					userObj.setRoleId("coordinator");
					break;

				default:
					System.out.println("Invalid Entry...");
					break;
			}
			
			userObj.setCreatedDate(LocalDate.now());
			
			//Data into ORM
			entityManager.persist(userObj);
			
			//Data into database
			transaction.commit();
			
			System.out.println("User added successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			emf.close();
		}
	}

	public void editUser() {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input  =  new Scanner(System.in);
		
		try {
			
			emf = Persistence.createEntityManagerFactory("UserDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			//start transaction 
			transaction.begin();
			
			System.out.print("Enter User Id:");
			int id = input.nextInt();
			User user = entityManager.find(User.class,id);
			
			System.out.print("Enter New username:");
			user.setUserName(input.next());
			
			entityManager.getTransaction().commit();
			
			System.out.println("Username Updated.");
			
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			emf.close();
		}
	}

	public void enableOrDisableUser() {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input  =  new Scanner(System.in);
		
		try {
			
			emf = Persistence.createEntityManagerFactory("UserDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			//start transaction 
			transaction.begin();
			
			System.out.print("Enter User Id:");
			int id = input.nextInt();
			User user = entityManager.find(User.class,id);
			
			if(user.getIsDisabled()) {
				System.out.print("User is disabled.\n Enable(y/n)");
				switch (input.next().charAt(0)) {
				case 'y':
					user.setDisabled(!user.getIsDisabled());
					break;
				case 'n':
					break;
				default:
					System.out.println("Going back.");
					break;
				}
			}else {
				
				System.out.print("User is Enabled.\n Disable(y/n)");
				switch (input.next().charAt(0)) {
				case 'y':
					user.setDisabled(!user.getIsDisabled());
					break;
				case 'n':
					break;
				default:
					System.out.println("Going back.");
					break;
				}
				
			}
			
			entityManager.getTransaction().commit();
			
			System.out.println("User Updated.");
			
		} catch (Exception e) {
			transaction.rollback();
		}finally {
			emf.close();
		}
	}

	public void listAllUsers() {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		
		try {
			
			emf = Persistence.createEntityManagerFactory("UserDB");
			entityManager = emf.createEntityManager();
			
			List<User> users = (List<User>) entityManager.createQuery("FROM User",User.class).getResultList();
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-20s %-20s %-20s %-20s %-20s \n",
					"UserID","User Name","User Role","Created Date","Disabled");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
			for(User user: users) {
				
				System.out.printf("%-20d %-20s %-20s %-20s %-20b \n",
					user.getUserId(),
					user.getUserName(),
					user.getRoleId(),
					user.getCreatedDate(),
					user.getIsDisabled());
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchByName() {
		// TODO Auto-generated method stub
		
	}
	

}
