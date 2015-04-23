package com.fdmgroup.chocolatestore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.chocolatectore.entities.Sale;
import com.fdmgroup.chocolatestore.interfaces.IStorable;
import com.fdmgroup.chocolatestore.interfaces.IStorage;
import com.fdmgroup.chocolatestore.singleton.EMFSingleton;

public class SaleDAO implements IStorage<Sale, Integer>{

	@Override
	public Sale read(Integer id) {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Sale sale = em.find(Sale.class, id);
		return sale;
	}

	@Override
	public Sale create(Sale sale) {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(sale);
		em.getTransaction().commit();
		
		return sale;
	}

	@Override
	public Sale update(Sale oldSale, Sale newSale) {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Sale result = em.find(Sale.class, oldSale.getSalesId());
		em.getTransaction().begin();
		result.setProductSales(newSale.getProductSales());
		result.setSaleDate(newSale.getSaleDate());
		result.setUser(newSale.getUser());
		em.getTransaction().commit();
		
		return result;
	}

	@Override
	public void delete(Integer i) {
		// TODO Auto-generated method stub
	}

	
	
}
