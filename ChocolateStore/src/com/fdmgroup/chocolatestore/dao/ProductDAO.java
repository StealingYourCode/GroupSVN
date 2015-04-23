package com.fdmgroup.chocolatestore.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.interfaces.IStorage;

public class ProductDAO extends SuperDAO implements IStorage<Product, Integer> {

	EntityManager em;
	@Override
	public Product read(Integer id) throws StorableNotFoundException, NullInputException {
		
		if(id==null)
			throw new NullInputException("The input cannot be null");
		em = emf.createEntityManager();
		Product product = em.find(Product.class, id);
		
		if(product==null)
			throw new StorableNotFoundException("This product was not found");

		return product;
	}
	

	@Override
	public Product create(Product product)throws StorableNotFoundException{
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		if(product==null)
			throw new StorableNotFoundException("This product was not found");
		
		return product;
	}

	@Override
	public Product update(Product oldProduct, Product newProduct)throws StorableNotFoundException{
		
		em = emf.createEntityManager();
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
		em = emf.createEntityManager();
		Product product = em.find(Product.class, i);
		
		if (product==null)
			throw new StorableNotFoundException("This product does not exist");
		
		em.getTransaction().begin();
		em.remove(product);
		em.getTransaction().commit();
	}
	
	public Product read(String name) throws StorableNotFoundException{
		em = emf.createEntityManager();
		Query query = em.createNamedQuery("SELECT '"+name+"' FROM PRODUCT", Product.class);
		Product product = (Product) query.getSingleResult();
		
		if(product==null)
			throw new StorableNotFoundException("This product was not found");
		
		return product;
	}
	
	public ArrayList<Product> readAll() {
		em = emf.createEntityManager();
		Query query = em.createNativeQuery("SELECT * FROM PRODUCT", Product.class);
		ArrayList<Product> productList = (ArrayList<Product>) query.getResultList();
		
		return productList;
		
	}
}
