package com.fdmgroup.chocolatestore.test.businesslogic;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;
import com.fdmgroup.springmvc.BusinessLogic;
import com.fdmgroup.springmvc.CSController;


public class BusinessLogicTests {
	ApplicationContext context = ContextSingleton.getSpring();

	BusinessLogic bl = new BusinessLogic();//(BusinessLogic) context.getBean("BusinessLogic");
	ProductDAO dao =  new ProductDAO();//(ProductDAO) context.getBean("ProductDAO");
	CSController cs = new CSController();
	

	@Test
	public void testAfterPurchaseInventory(){

		try {
		bl.purchase("Snickers", 5, "email@email.com");
		
			assertTrue(dao.read(3).getStockAmount()==25);
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	}
	
//	@Test
//	public void loginTest(){
//		
//		try {
//			User user= bl.Login("email@email.com", "password");
//			assertTrue(user.getUserId()==1100);
//		} catch (NullInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void TestLoginThrowsException(){
//		try {
//			User user = bl.Login("gibberish", "password");
//		} catch (NullInputException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	}
	
//	@Test
//	public void testRegister(){
//		bl.Register("Louis", "password");
//	}
	
}
