package com.nissan.service;

import java.util.Scanner;

import com.nissan.repo.CredRepositoryImpl;
import com.nissan.repo.ICredRepository;

public class ProfessorServiceImpl {

	
	//Repo Layer
	ICredRepository crud = new CredRepositoryImpl();
	
	Scanner input  = new Scanner(System.in);
	char choice = 'y';
	
	public ProfessorServiceImpl() {
		super();
		
	}
	
	///Menu Driven
	

	public void menuDriven() {
		
		do {
			//Show choice
			System.out.println("1. Add Professor \n "
						     + "2. Search Professor \n"
						     + "3. Edit Professor \n"
						     + "4. Delete Professor"
						     + "5. List all Professors \n"
						     + "6. Exit \n"
						     + "Enter your option:");
			int option = input.nextInt();
			
			switch (option) {
			case 1:
				crud.insertEntity();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;

			default:
				System.out.println("Invalid entry!!!");
				break;
			}
		}while(choice=='Y' ||choice == 'y');
	}
}
