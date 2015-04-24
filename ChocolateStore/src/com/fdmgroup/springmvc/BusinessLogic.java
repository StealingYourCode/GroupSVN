package com.fdmgroup.springmvc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.dao.SaleDAO;
import com.fdmgroup.chocolatestore.dao.UserDAO;
import com.fdmgroup.chocolatestore.entities.Product;
import com.fdmgroup.chocolatestore.entities.ProductSale;
import com.fdmgroup.chocolatestore.entities.Sale;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

public class BusinessLogic {
	ApplicationContext context = ContextSingleton.getSpring();

	public synchronized void updateInventory(String name, int amount, String username) throws NullInputException{
		ProductDAO dao = (ProductDAO) context.getBean("ProductDAO");
		Sale sale = (Sale) context.getBean("Sale");
		UserDAO userDao = (UserDAO) context.getBean("UserDAO");
		SaleDAO saleDao = (SaleDAO) context.getBean("SaleDAO");
		ProductSale ps = (ProductSale) context.getBean("ProductSale");
		List<ProductSale> psList = new ArrayList<ProductSale>();
		
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
				sale.setUser(userDao.read(username));
				ps.setProduct(product);
				ps.setQuantity(amount);
				ps.setSale(sale);
				psList.add(ps);
				sale.setProductSales(psList);
				
				saleDao.create(sale);
				
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
