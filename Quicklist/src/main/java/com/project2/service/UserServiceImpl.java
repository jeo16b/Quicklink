package com.project2.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.models.Users;
import com.project2.repository.UserRepository;

@Service("UserService")
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

}
