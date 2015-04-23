package com.fdmgroup.chocolatestore.test.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;

public class ProductDAOTest {
	private ProductDAO dao;
	
	@Test
	public void testPoductIsCreated() 
	{
		Product product = new Product("Snickers",new BigDecimal(2.45), 100, "Packed with roasted peanuts, nougat, caramel and milk chocolate. SNICKERS Brand handles your hunger, so you handle the things in life that aren't related to hunger at all." );
		
		
		
		dao=new ProductDAO();
		try {
			assertTrue(dao.create(product) instanceof Product);
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
