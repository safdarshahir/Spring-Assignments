package com.nissan.repo;

import java.util.Optional;

import com.nissan.model.Professor;


public interface ICredRepository {

	//create professor
	public void insertEntity();
	
	//list all professor
	public void listAllProcessors();
	
	//Update professor
	public void editProfessor();
	
	//Delete professor
	public void deleteProfessor();
	
	//Search by Id
	public void searchById();
	//find by name
	
	public Optional<Professor> findByName(String name);
}
