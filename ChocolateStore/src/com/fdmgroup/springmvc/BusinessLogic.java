package com.fdmgroup.springmvc;

import org.springframework.context.ApplicationContext;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

public class BusinessLogic {
	ApplicationContext context = ContextSingleton.getSpring();

	public void updateInventory(String name, int amount){
		ProductDAO dao = (ProductDAO) context.getBean("ProductDAO");
		
		try {// TODO Find out how many units were purchased and subtract then update the product inventory
			Product product = dao.read(name);
			if(product.getStockAmount()<amount){
				//redirect to insufficent quantity page
			}
			
			else{
				Product newProduct= copyProduct(product);
				newProduct.setStockAmount(product.getStockAmount()-amount);
				dao.update(product, newProduct);
			}
		} catch (StorableNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Product copyProduct(Product product){
		Product productCopy= (Product) context.getBean("Product");
		
		productCopy.setDescription(product.getDescription());
		productCopy.setName(product.getName());
		productCopy.setPrice(product.getPrice());
		productCopy.setProductSales(product.getProductSales());
		productCopy.setStockAmount(product.getStockAmount());
		
		return productCopy;
		
		
	}
}
