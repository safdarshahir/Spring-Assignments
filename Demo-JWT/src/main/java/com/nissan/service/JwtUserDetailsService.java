package com.nissan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nissan.model.DAOUser;
import com.nissan.model.UserDTO;
import com.nissan.repo.IUserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		/*
		if ("nissan".equals(username)) {
			System.out.println("UserDetails: " + username);
			return new User("nissan", "$2a$10$TvXuClKFTM.2RyZ4TD5cJuEayMY6gHMdWLihscY7JNG1vxuHEPhbS",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		*/
		
		DAOUser user = userRepository.findUserByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}
}