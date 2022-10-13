package com.nissan.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.DAOUser;

@Repository
public interface IUserRepository extends CrudRepository<DAOUser,String>{
	
	DAOUser findUserByUserName(String userName);

}
