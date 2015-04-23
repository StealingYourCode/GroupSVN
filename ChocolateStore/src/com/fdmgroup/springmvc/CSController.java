package com.fdmgroup.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

@Controller
public class CSController {

	ApplicationContext context = ContextSingleton.getSpring();
	
	@RequestMapping("/")
	public String goToHome() {
		
		return "csFrontPage";
	}
	
	public void updateInventory(String name, int amount){
		ProductDAO dao = (ProductDAO) context.getBean("ProductDAO");
		
		try {// TODO Find out how many units were purchased and subtract then update the product inventory
			Product product = dao.read(name);
			if(product.getStockAmount()<amount){
				//redirect to insufficent quantity page
			}
			
			else{
				newProduct=
			}
		} catch (StorableNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
}
