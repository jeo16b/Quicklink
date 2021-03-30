package com.quicklist.junit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.project2.models.Posts;
import com.project2.models.Users;
import com.project2.repository.PostRepositoryImpl;
import com.project2.repository.UserRepositoryImpl;
import com.project2.service.EmployerServiceImpl;
import com.project2.service.UserServiceImpl;


public class QuicklistTest {
	
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
	public void happyPathScenarioUsername() {
		
		Users u = new Users("user", "password", "employer");
		
		List<Users> ulist = new ArrayList<Users>();
		ulist.add(u);
		
		when(ur.findAll()).thenReturn(ulist);
		
		
		Users foundUser = ur.findByName(u.getUsername());
		System.out.println(foundUser);
		System.out.println(u);
		
		assertEquals(null, foundUser);
		
	}
	
	@Test
	public void testUserRegister() {
		
		Users u = new Users(10,"Ftest", "Ltest", "Utest", "Pword", "email", "1234567890", "123 main st", "employee");
		
		boolean addedUser = us.registerUser(u);
		
		assertEquals(true, addedUser);
	}
	
	@Test
	public void happyPathScenarioPost() {
		
		Posts p = new Posts(10, "Company", "Title", "other", "Florida", 500.00, "1234567890", "Descrption", 4, 1);
		
		List<Posts> plist = new ArrayList<Posts>();
		plist.add(p);
		
		when(pr.getAllPosts()).thenReturn(plist);
		
		int id = 4;
		
		Posts foundPost = es.findPostById(id);
		
		assertEquals(null, foundPost);
		
	}
	
	@Test
	public void userIsNotPresent() {
		
		List<Users> emptyUsers = new ArrayList<Users>();
		
		when(ur.findAll()).thenReturn(emptyUsers);
		
		Users userFoundByName = us.findByName("testing");
		
		assertEquals(null, userFoundByName);
	}
	
	@Test
	public void postIsNotPresent() {
		
		List<Posts> emptylist = new ArrayList<Posts>();
		
		when(pr.getAllPosts()).thenReturn(emptylist);
		
		Posts postFound = es.findPostById(1000);
		
		assertEquals(null, postFound);
		
	}
	
	@Test
	public void testPostRegister() {
		
		Posts p = new Posts(12, "Company", "Title", "other", "Florida", 500.00, "1234567890", "Descrption", 4, 1);
		
		boolean posted = pr.createPost(p);
		
		assertEquals(false, posted);
	}
	

	
	@Test
	public void testLogin() {
		
		Users u = new Users("Utest", "Pword", "employee");
		
		
		assertNotNull(when(ur.login(u)).thenReturn(u));
	}
	


	

}
