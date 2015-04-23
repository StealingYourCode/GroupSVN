package com.fdmgroup.chocolatestore.test.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;

public class ProductDAOTest {
	private ProductDAO dao;
	Product product1, product2, product3, product4, product5, product6, product7, product8;
	
	@Test
	public void testPoductIsCreated() 
	{

		product1 = new Product("Snickers",new BigDecimal(2.45), 100, "Packed with roasted peanuts, nougat, caramel and milk chocolate. SNICKERS Brand handles your hunger, so you handle the things in life that aren't related to hunger at all." );
		product2 = new Product("Butterfinger",new BigDecimal(1.99), 100, "The Nestle Butterfinger bar is a crunchy, flaky peanut butter bar covered in a layer of chocolate - loved the world over." );
		product3 = new Product("Mars",new BigDecimal(2.15), 100, "The original chocolate bar created by Forrest Mars in 1932. A delicious fusion of chocolate, caramel and nougat has been rewarding and restoring people for generations. Mars - Work, Rest and Play your part" );
		product4 = new Product("Twix",new BigDecimal(1.99), 100, "TWIX® is crunchy flavorful cookie, delicious chewy caramel, and smooth creamy chocolate. This combination makes your Left TWIX® authentic, be weary of replica peddlers like our neighbors there." );
		product5 = new Product("Cadbury",new BigDecimal(2.99), 100, "Delicious English Chocolate that Shana likes to eat whilst teaching. It's way better than any American chocolate" );
		product6 = new Product("KitKat",new BigDecimal(1.49), 100, "The delicious combination of smooth milk chocolate and light, crispy wafers." );
		product7 = new Product("encore!",new BigDecimal(3.99), 100, "Caramel and Biscuit enrobed in milk chocolate" );
		product8 = new Product("Klik",new BigDecimal(4.25), 100, "Fine Milk Chocolate Crispy Bars, Filled with Nougat" );
		
		dao=new ProductDAO();
		try {
			assertTrue(dao.create(product1) instanceof Product);
			assertTrue(dao.create(product2) instanceof Product);
			assertTrue(dao.create(product3) instanceof Product);
			assertTrue(dao.create(product4) instanceof Product);
			assertTrue(dao.create(product5) instanceof Product);
			assertTrue(dao.create(product6) instanceof Product);
			assertTrue(dao.create(product7) instanceof Product);
			assertTrue(dao.create(product8) instanceof Product);
			
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
