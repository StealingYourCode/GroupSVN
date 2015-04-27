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
	ApplicationContext context;
	List<ProductSale> psList;
	ProductDAO productDao;//(ProductDAO) context.getBean("ProductDAO");
	Sale sale;//(Sale) context.getBean("Sale");
	UserDAO userDao;//(UserDAO) context.getBean("UserDAO");
	SaleDAO saleDao = new SaleDAO();//(SaleDAO) context.getBean("SaleDAO");
	ProductSaleDAO psDao;//(ProductSaleDAO) context.getBean("ProductSaleDAO");
	
	public BusinessLogic() {
		//context = ContextSingleton.getSpring();
		productDao = new ProductDAO();
		userDao = new UserDAO();
		psDao = new ProductSaleDAO();
		psList = new ArrayList<ProductSale>();
	}
	public synchronized void purchase(String name, int amount,
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
				sale = new Sale();
				Product newProduct = copyProduct(product);
				newProduct.setStockAmount(product.getStockAmount() - amount);

				productDao.update(product, newProduct);
				sale.setSaleDate(Calendar.getInstance());
				sale.setUser(userDao.read(username));

				saleDao.create(sale);
//				psDao.create(setProductSale(product, amount, sale));

			}
		} catch (StorableNotFoundException e) {

			e.printStackTrace();
		}
	}

	public Product copyProduct(Product product) {
		Product productCopy = new Product();//(Product) context.getBean("Product");

		productCopy.setDescription(product.getDescription());
		productCopy.setProductName(product.getProductName());
		productCopy.setPrice(product.getPrice());
		productCopy.setStockAmount(product.getStockAmount());
		

		return productCopy;

	}

	public ProductSale setProductSale(Product product, int amount, Sale sale) {

		ProductSale ps = new ProductSale();//(ProductSale) context.getBean("ProductSale");
		ps.setProduct(product);
		ps.setQuantity(amount);
		ps.setSale(sale);
		return ps;
	}

	public User login(String username, String password)
			throws NullInputException, StorableNotFoundException {
		System.out.println("in login");
		if (username == null || password == null) {
			System.out.println("null");
			throw new NullInputException("Email or password cannot be null");
		}

		try {
			System.out.println("after null");
			User user = userDao.read(username);
			System.out.println("after read");
			if (user.getPassword().equals(password))
				return user;
		} catch (NoResultException e) {
			throw new StorableNotFoundException("This user does not exist");
		}
		return null;

	}

	public User register(User user) {
		

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
