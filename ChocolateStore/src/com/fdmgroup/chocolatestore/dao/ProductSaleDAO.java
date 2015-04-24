package com.fdmgroup.chocolatestore.dao;

import javax.persistence.EntityManager;

import com.fdmgroup.chocolatestore.entities.ProductSale;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.interfaces.IStorage;

public class ProductSaleDAO extends SuperDAO implements IStorage<ProductSale, Integer> {
	
	EntityManager em;

	@Override
	public ProductSale read(Integer i) throws StorableNotFoundException,
			NullInputException {
		return null;
	}

	@Override
	public ProductSale create(ProductSale productsale) throws StorableNotFoundException {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(productsale);
		em.getTransaction().commit();
		
		return productsale;
	}

	@Override
	public ProductSale update(ProductSale t, ProductSale a)
			throws StorableNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer i) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
