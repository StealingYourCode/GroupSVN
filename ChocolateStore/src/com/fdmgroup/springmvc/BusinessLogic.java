package com.fdmgroup.springmvc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.context.ApplicationContext;

import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.dao.ProductSaleDAO;
import com.fdmgroup.chocolatestore.dao.SaleDAO;
import com.fdmgroup.chocolatestore.dao.UserDAO;
import com.fdmgroup.chocolatestore.entities.Product;
import com.fdmgroup.chocolatestore.entities.ProductSale;
import com.fdmgroup.chocolatestore.entities.Sale;
import com.fdmgroup.chocolatestore.entities.User;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

public class BusinessLogic {
	ApplicationContext context = ContextSingleton.getSpring();
	List<ProductSale> psList = new ArrayList<ProductSale>();
	ProductDAO productDao = (ProductDAO) context.getBean("ProductDAO");
	Sale sale = (Sale) context.getBean("Sale");
	UserDAO userDao = (UserDAO) context.getBean("UserDAO");
	SaleDAO saleDao = (SaleDAO) context.getBean("SaleDAO");
	ProductSaleDAO psDao = (ProductSaleDAO) context.getBean("ProductSaleDAO");

	public synchronized void updateInventory(String name, int amount,
			String username) throws NullInputException {

		if (amount < 0) {
			throw new NullInputException("Amount cannot be less than 0");
		}

		try {
			Product product = productDao.read(name);
			if (product.getStockAmount() < amount) {
				// redirect to insufficent quantity page
			}

			else {
				Product newProduct = copyProduct(product);
				newProduct.setStockAmount(product.getStockAmount() - amount);

				productDao.update(product, newProduct);
				sale.setSaleDate(Calendar.getInstance());
				sale.setUser(userDao.read(username));

				saleDao.create(sale);
				psDao.create(setProductSale(newProduct, amount, sale));

			}
		} catch (StorableNotFoundException e) {

			e.printStackTrace();
		}
	}

	public Product copyProduct(Product product) {
		Product productCopy = (Product) context.getBean("Product");

		productCopy.setDescription(product.getDescription());
		productCopy.setProductName(product.getProductName());
		productCopy.setPrice(product.getPrice());
		productCopy.setStockAmount(product.getStockAmount());

		return productCopy;

	}

	public ProductSale setProductSale(Product product, int amount, Sale sale) {

		ProductSale ps = (ProductSale) context.getBean("ProductSale");
		ps.setProduct(product);
		ps.setQuantity(amount);
		ps.setSale(sale);
		return ps;
	}

	public User Login(String username, String password)
			throws NullInputException, StorableNotFoundException {

		if (username == null || password == null) {
			throw new NullInputException("Email or password cannot be null");
		}

		try {
			User user = userDao.read(username);

			if (user.getPassword().equals(password))
				return user;
		} catch (NoResultException e) {
			throw new StorableNotFoundException("This user does not exist");
		}
		return null;

	}

	public User Register(String username, String password) {
		User user = (User) context.getBean("User");
		user.setEmail(username);
		user.setPassword(password);

		try {
			userDao.create(user);
			return user;
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}

		return null;

	}
}
