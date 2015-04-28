package com.fdmgroup.droplocker2.dao.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.droplocker2.businesslogic.BeanSingleton;
import com.fdmgroup.droplocker2.dao.Storage;
import com.fdmgroup.droplocker2.entities.Customer;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class CustomerDAOtest {
	
	Storage dao;
	Customer user, user1, user2;
	BeanSingleton beans;
	
	@Before
	public void setUp() {
		user1 = new Customer("zvilamm", "password");
		user2 = new Customer("zvilamm", "secret");
	}
	
	@Test
	public void testCreateUser() throws StorableNotFoundException, StorableNullException {
		dao = (Storage) beans.getSpring().getBean("UserDAO");
		dao.create(user1);
	}
	
	@Ignore
	@Test//TODO(expected= replace with specific exception).class)
	public void testCreateDuplicateUsername() throws StorableNotFoundException, StorableNullException {
		dao = (Storage) beans.getSpring().getBean("UserDAO");
		dao.create(user2);
	}

}
