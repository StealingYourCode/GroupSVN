package com.fdmgroup.chocolatestore.test.dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;

public class ProductDAOTest {
	private ProductDAO dao;
	Product product, product1, product2, product3, product4, product5, product6, product7, product8;
	
	@Before
	public void setUp() throws Exception {
		dao=new ProductDAO();
	}
	
	@Ignore
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
	
	@Test
	public void testProductRead()
	{
		Product product;
		try {
			product=dao.read(3);
			assertTrue(product.getProductName().equals("Snickers"));
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProductUpdateTest()
	{
		Product product = new Product("Fancy", new BigDecimal(90), 100,"this is fancy");
		Product productupdate = product;
		productupdate.setStockAmount(50);
		try {
			dao.create(product);
			dao.update(product, productupdate);
			try {
				assertTrue(dao.read(11).getStockAmount().equals(50));
				dao.delete(11);
				assertTrue(dao.read(11).equals(null));
			} catch (NullInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (StorableNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	@Test 
	public void testProductDeleteTest(){
		try {
			dao.delete(12);
			assertTrue(dao.read(12).equals(null));
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
