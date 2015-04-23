package com.fdmgroup.chocolatestore.test.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;

public class ProductDAOTest {
	private ProductDAO dao;
	
	@Test
	public void testPoductIsCreated() 
	{
		Product product = new Product();
		
		product.setName("Fancy Chocolate");
		product.setPrice(new BigDecimal(123.45));
		product.setStockAmount(new BigDecimal(140));
		product.setDescription("This is so fancy it will blow your socks off!");
		
		dao=new ProductDAO();
		
		assertTrue(dao.create(product) instanceof Product);
	}

}
