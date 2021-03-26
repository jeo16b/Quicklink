package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import static com.project2.util.ClientMessageUtil.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project2.ajax.ClientMessage;
import com.project2.models.Posts;
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
	public @ResponseBody ClientMessage registerUser(@RequestBody Users u) {
		
		return (userService.registerUser(u)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
		
	}

	@PostMapping("/findUser")
	public @ResponseBody Users findUser(@RequestBody Users u, HttpServletRequest req) {
		req.getSession();
		return userService.getUser(u.getId());
	}

	@GetMapping("/findAllUsers")
	public @ResponseBody List<Users> findAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/findPostApplied")
	public @ResponseBody List<Posts> findPostApplied(@RequestBody Users u, HttpServletRequest req){
		req.getSession();
		return userService.getPostApplied(u);
	}

}
