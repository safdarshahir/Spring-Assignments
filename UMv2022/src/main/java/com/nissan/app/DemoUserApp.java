package com.nissan.app;

import java.util.logging.Level;

import com.nissan.service.UserServiceImpl;

public class DemoUserApp {

	public static void main(String[] args) {

		//configuring to show only severe logging info
		java.util.logging.Logger.getLogger("com.hibernate").setLevel(Level.SEVERE);
		
		UserServiceImpl userService = new UserServiceImpl();
		userService.menu();
	}

}
