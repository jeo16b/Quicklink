package com.project2.service;

import java.util.List;

import com.project2.models.Posts;
import com.project2.models.Users;

public interface UserService {
	
	public boolean registerUser(Users u);
	
	public Users getUser(int id);
	
	public List<Users> getAllUsers();
	
	public List<Posts> getPostApplied(Users u);
	
	public boolean updateUser(Users u);

	Users login(Users u);

}
