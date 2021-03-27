package com.project2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project2.ajax.ClientMessage;
import com.project2.models.Posts;
import com.project2.models.Users;

public interface UserController {
	
	ClientMessage registerUser(Users u);
	
	Users findUser(Users u, HttpServletRequest req);
	
	List<Users> findAllUsers();
	
	boolean updateUser(Users u);
	
	ClientMessage registerPost(Posts post);
	
	boolean updatePost(Posts post);
	
	ClientMessage deletePost(Posts post);
	
	Users login(Users u);
	

}
