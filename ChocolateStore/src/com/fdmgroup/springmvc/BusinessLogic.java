package com.fdmgroup.springmvc;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;

import com.fdmgroup.chocolatestore.entities.Product;
import com.fdmgroup.chocolatestore.entities.Sale;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

public class BusinessLogic {
	ApplicationContext context = ContextSingleton.getSpring();

	public synchronized void updateInventory(String name, int amount) throws NullInputException{
		ProductDAO dao = (ProductDAO) context.getBean("ProductDAO");
		Sale sale = (Sale) context.getBean("Sale");
		
		if(amount<0){
			throw new NullInputException("Amount cannot be less than 0");
		}
		
		try {
			Product product = dao.read(name);
			if(product.getStockAmount()<amount){
				//redirect to insufficent quantity page
			}
			
			else{
				Product newProduct= copyProduct(product);
				newProduct.setStockAmount(product.getStockAmount()-amount);
				dao.update(product, newProduct);
				sale.setSaleDate(Calendar.getInstance());
				sale.setUser(user);
			}
		} catch (StorableNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Product copyProduct(Product product){
		Product productCopy= (Product) context.getBean("Product");
		
		productCopy.setDescription(product.getDescription());
		productCopy.setProductName(product.getProductName());
		productCopy.setPrice(product.getPrice());
		productCopy.setStockAmount(product.getStockAmount());
		
		return productCopy;
		
		
	}
}
