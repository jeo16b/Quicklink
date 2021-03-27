package com.project2.controller;

import static com.project2.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.project2.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project2.ajax.ClientMessage;
import com.project2.models.Posts;
import com.project2.models.Users;
import com.project2.service.EmployerService;
import com.project2.service.UserService;
import com.project2.util.ClientMessageUtil;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerImpl implements UserController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmployerService emplService;
	
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
	
	@PostMapping("/registerPost")
	public @ResponseBody ClientMessage registerPost(@RequestBody Posts post)
	{
		return (emplService.registerMyPost(post))? REGISTRATION_SUCCESSFUL:SOMETHING_WRONG;
	}
	
	@PostMapping("/updatePost")
	public @ResponseBody boolean updatePost(@RequestBody Posts post)
	{
		return emplService.updateMyPost(post);
	}
	
	@PostMapping("/delete")
	public @ResponseBody ClientMessage deletePost(@RequestBody Posts post)
	{
		return (emplService.deleteMyPost(post))? ClientMessageUtil.DELETE_SUCCESSFUL: ClientMessageUtil.DELETE_ERROR;
	}
	
	@PostMapping("/login")
	public @ResponseBody Users login(@RequestBody Users u)
	{
		return userService.login(u);
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

	@PostMapping("/updateUserInfo")
	public @ResponseBody boolean updateUser(@RequestBody Users u) {	
		return userService.updateUser(u);
	}

}
