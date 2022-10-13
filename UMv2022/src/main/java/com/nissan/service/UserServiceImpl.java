package com.nissan.service;

import java.util.Scanner;

import com.nissan.repo.CrudRepoImpl;
import com.nissan.repo.ICrudRepo;

public class UserServiceImpl {
	
	ICrudRepo crudRepo = new CrudRepoImpl();
	Scanner input = new Scanner(System.in);
	char choice = 'y';
	
	//Default constructor
	public UserServiceImpl() {
		super();
	}
	
	public void menu() {
		

			
			do {
				//Show choice
				System.out.print("\n 1. Add User \n"
							     + " 2. Edit Users \n"
							     + " 3. Disable User  \n"
							     + " 4. List User \n"
							     + " 5. Search by name \n"
							     + " 6. Exit \n"
							     + " Enter your option:");
				int option = input.nextInt();
				
				switch (option) {
				case 1:
					crudRepo.addUser();
					break;
				case 2:
					crudRepo.editUser();					
					break;
				case 3:
					crudRepo.enableOrDisableUser();
					break;
				case 4:
					crudRepo.listAllUsers();
					break;
				case 5:
					System.out.print("Enter name:");
					String name = input.next();
					crudRepo.searchByName();
					break;
				case 6:
					System.out.println("Exiting");
					System.exit(0);
				default:
					System.out.println("Invalid entry!!!");
					break;
				}
			}while(choice=='Y' ||choice == 'y');
		}
		
	
	
	
	
	

}
