package com.project2.repository;


import java.util.List;

import com.project2.models.Posts;
import com.project2.models.Users;

public interface UserRepository {
	
	void register(Users u);
	
	Users findById(int id);
	
	List<Users> findAll();
	
	List<Posts> findPostApplied(Users u);
	
	

}
