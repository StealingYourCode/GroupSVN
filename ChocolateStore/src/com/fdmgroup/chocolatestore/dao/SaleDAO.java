package com.fdmgroup.chocolatestore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.chocolatectore.entities.Sale;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.interfaces.IStorable;
import com.fdmgroup.chocolatestore.interfaces.IStorage;

public class SaleDAO extends SuperDAO implements  IStorage<Sale, Integer>{

	EntityManager em;
	
	@Override
	public Sale read(Integer id) throws StorableNotFoundException {
		
		em = emf.createEntityManager();
		Sale sale = em.find(Sale.class, id);
		
		if(sale==null)
			throw new StorableNotFoundException("This sale was not found");
		return sale;
	}

	@Override
	public Sale create(Sale sale) throws StorableNotFoundException {
		
		if(sale==null)
			throw new StorableNotFoundException("This sale was not found");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(sale);
		em.getTransaction().commit();
		
		return sale;
	}

	@Override
	public Sale update(Sale oldSale, Sale newSale) throws StorableNotFoundException {
		
		if(oldSale==null|| newSale==null)
			throw new StorableNotFoundException("This sale was not found");
		
		
		em = emf.createEntityManager();
		Sale result = em.find(Sale.class, oldSale.getSalesId());
		em.getTransaction().begin();
		result.setProductSales(newSale.getProductSales());
		result.setSaleDate(newSale.getSaleDate());
		result.setUser(newSale.getUser());
		em.getTransaction().commit();
		
		return result;
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		em = emf.createEntityManager();
		Sale sale = em.find(Sale.class, id);
		
		if(sale==null)
			throw new StorableNotFoundException("This sale was not found");
		
		em.getTransaction().begin();
		em.remove(sale);
		em.getTransaction().commit();
	
	}

	
	
}
