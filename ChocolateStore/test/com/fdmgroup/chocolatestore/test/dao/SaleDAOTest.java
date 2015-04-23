package com.fdmgroup.chocolatestore.test.dao;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.chocolatectore.entities.Sale;
import com.fdmgroup.chocolatectore.entities.User;
import com.fdmgroup.chocolatestore.dao.SaleDAO;
import com.fdmgroup.chocolatestore.dao.UserDAO;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;

public class SaleDAOTest {
	private SaleDAO dao;
	private Sale sale;

	@Before
	public void setUp() throws Exception {
		dao=new SaleDAO(); //TODO: change to beans
	}
	
	@Ignore
	@Test
	public void testCreateSale() throws StorableNotFoundException {
		
		sale = new Sale(); //TODO: change to beans
		
		UserDAO userdao = new UserDAO();
		
		User user = userdao.read(1100);	
		
		sale.setSaleDate(Calendar.getInstance());
		sale.setUser(user);
				
		assertTrue(dao.create(sale) instanceof Sale);
	}
	
	@Test
	public void testReadSale() throws StorableNotFoundException{
		
		assertTrue(dao.read(1000).getUser() instanceof User);

	}

}
