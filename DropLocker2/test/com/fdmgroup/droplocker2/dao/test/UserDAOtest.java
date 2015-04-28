package com.fdmgroup.droplocker2.dao.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.droplocker2.businesslogic.BeanSingleton;
import com.fdmgroup.droplocker2.entities.User;

public class UserDAOtest {
	
	Storage dao;
	User user, user1, user2;
	BeanSingleton beans;
	
	@Before
	public void setUp() {
		user1 = new User("zvilamm", "password");
		user2 = new User("zvilamm", "secret");
	}
	
	@Test
	public void testCreateUser() {
		dao = beans.getSpring().getBean("UserDAO");
		dao.create(user1);
		
	}
	
	@Test(expected=//TODO replace with specific exception).class)
	public void testCreateDuplicateUsername() {
		dao = beans.getSpring().getBean("UserDAO");
		dao.create(user2);
	}

}
