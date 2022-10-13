package com.nissan.repo;

public interface ICrudRepo {

	//Add user
	public void addUser();
	
	//Edit user
	public void editUser();
	
	//Disable user
	public void enableOrDisableUser();
	
	//List users
	public void listAllUsers();
	
	//Search User by name
	public void searchByName();
	
}
