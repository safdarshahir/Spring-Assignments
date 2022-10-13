package com.nissan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class HelloController {

	@RequestMapping({"/hello"})
	public String hello() {
		System.out.println("Inside hello!!!");
		return "Hello World";
	}
}
