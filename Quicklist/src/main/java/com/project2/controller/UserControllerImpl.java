package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project2.models.Users;
import com.project2.service.UserService;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerImpl implements UserController{
	
	@Autowired
	private UserService userService;
	
	/*
	 * @RequestMapping (Get or Post) tells specifies the URL at which we can trigger these methods
	 * 
	 * @ResponseBody marshals our POJOs into JSON with Jackson (since we have the dependency)
	 * 
	 * @RequestBody UN-marshals the JSON into a Java POJO
	 * 
	 */
	
	
	@PostMapping("/register") // localhost:8080/Quicklist/register
	public @ResponseBody boolean registerUser(@RequestBody Users u) {
		return (userService.registerUser(u));
	}

}
