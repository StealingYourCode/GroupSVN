package com.fdmgroup.chocolatestore.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.interfaces.IStorable;
import com.fdmgroup.chocolatestore.interfaces.IStorage;
import com.fdmgroup.chocolatestore.singleton.EMFSingleton;

public class ProductDAO extends SuperDAO implements IStorage<Product, Integer> {

	@Override
	public Product read(Integer id) throws StorableNotFoundException, NullInputException {
		
		if(id==null)
			throw new NullInputException("The input cannot be null");

		Product product = em.find(Product.class, id);
		
		if(product==null)
			throw new StorableNotFoundException("This product was not found");

		return product;
	}
	

	@Override
	public Product create(Product product)throws StorableNotFoundException{
		

		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		
		if(product==null)
			throw new StorableNotFoundException("This product was not found");
		
		return product;
	}

	@Override
	public Product update(Product oldProduct, Product newProduct)throws StorableNotFoundException{
		

		Product result = em.find(Product.class, oldProduct.getProductId());
		
		if (result==null)
			throw new StorableNotFoundException("This product does not exist");

		em.getTransaction().begin();
		result.setDescription(newProduct.getDescription());
		result.setName(newProduct.getName());
		result.setPrice(newProduct.getPrice());
		result.setProductSales(newProduct.getProductSales());
		result.setStockAmount(newProduct.getStockAmount());
		em.getTransaction().commit();

		return newProduct;
	}

	@Override
	public void delete(Integer i)throws StorableNotFoundException {
		
		Product product = em.find(Product.class, i);
		
		if (product==null)
			throw new StorableNotFoundException("This product does not exist");
		
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
	}
	
	public ArrayList<Product> readAll() {
		
		Query query = em.createNativeQuery("SELECT * FROM PRODUCT", Product.class);
		ArrayList<Product> productList = (ArrayList<Product>) query.getResultList();
		
		return productList;
		
	}
}
