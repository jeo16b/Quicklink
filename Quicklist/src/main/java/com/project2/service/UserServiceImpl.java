package com.project2.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.models.Users;
import com.project2.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		log.trace("Injection using Autowired User Repository in UserServiceImpl");
	}

	@Override
	public boolean registerUser(Users u) {
		userRepository.register(u);
		return u.getId() !=0;
		 
	}

	@Override
	public Users getUser(int id) {
	
		return userRepository.findById(id);
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

}
