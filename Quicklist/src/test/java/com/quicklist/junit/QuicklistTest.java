package com.quicklist.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.project2.models.Posts;
import com.project2.models.Users;
import com.project2.repository.PostRepositoryImpl;
import com.project2.repository.UserRepositoryImpl;
import com.project2.service.EmployerServiceImpl;
import com.project2.service.UserService;
import com.project2.service.UserServiceImpl;

class QuicklistTest {
	
	// classes to be tested
	private EmployerServiceImpl es;
	private UserServiceImpl us;
	
	private UserRepositoryImpl ur;
	private PostRepositoryImpl pr;
	
	@Before
	public void setup() {
		es = new EmployerServiceImpl();
		us = new UserServiceImpl();
		
		// mocking DB
		ur = mock(UserRepositoryImpl.class);
		pr = mock(PostRepositoryImpl.class);
		
		
		es.postRepo = pr;
		us.userRepository = ur;
		
	}
	
	@Test
	public void happyPathScenario() {
		
		Users u = new Users(5,"Ftest", "Ltest", "Utest", "Pword", "email", "1234567890", "123 main st", "employee");
		
		List<Users> ulist = new ArrayList<Users>();
		ulist.add(u);
		
		when(ur.findAll()).thenReturn(ulist);
		
		int dummyUname = u.getId();
		
		Users foundUser = us.getUser(dummyUname);
		
		assertEquals(u, foundUser);
		
	}


	

}
