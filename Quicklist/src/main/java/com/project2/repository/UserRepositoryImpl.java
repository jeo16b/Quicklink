package com.project2.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project2.models.Users;

public class UserRepositoryImpl implements UserRepository {
	
	private static Logger log = Logger.getLogger(UserRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRepositoryImpl() {
		log.trace("Injection session factory bean");
	}

	@Override
	public void register(Users u) {
		
		sessionFactory.getCurrentSession().save(u);
		
		
	}



}
