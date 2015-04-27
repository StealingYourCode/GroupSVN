package com.fdmgroup.chocolatestore.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.chocolatestore.entities.User;
import com.fdmgroup.chocolatestore.dao.UserDAO;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;

public class UserDAOTest {
	private UserDAO dao;
	private User user; 
	@Before
	public void setUp() throws Exception {
		dao=new UserDAO();
	}
//	@Ignore
	@Test
	public void testUserCreate() throws StorableNotFoundException {
		
		user = new User();
		user.setPassword("password");
		user.setEmail("other@email.com");
		user.setAddress("123 Some Street");
	
		assertTrue(dao.create(user) instanceof User);
		
	}
	@Ignore
	@Test
	public void testUserRead() throws StorableNotFoundException{
		
		assertTrue(dao.read(1000).getPassword().equals("password"));
		
	}
	@Ignore
	@Test
	public void testUserUpdate() throws StorableNotFoundException
	{
		User user2 = user;
		user2.setPassword("newPassword");
		
		dao.update(user, user2);
		assertTrue(dao.read(1000).getPassword().equals("newPassword"));
	}
	@Ignore
	@Test
	public void testUserDelete() throws StorableNotFoundException
	{
		dao.delete(1000);
		assertTrue(dao.read(1000).equals(null));
	}
}
