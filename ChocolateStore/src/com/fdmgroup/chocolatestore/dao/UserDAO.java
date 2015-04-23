package com.fdmgroup.chocolatestore.dao;

import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.chocolatectore.entities.User;
import com.fdmgroup.chocolatestore.interfaces.IStorable;
import com.fdmgroup.chocolatestore.interfaces.IStorage;
import com.fdmgroup.chocolatestore.singleton.EMFSingleton;

public class UserDAO implements IStorage<User, Integer>{

	@Override
	public User read(Integer id) {
		
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, id);
		
		return  user;
	}

	@Override
	public User create(User user) {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		return user;
	}

	@Override
	public User update(User oldUser, User newUser) {
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		User result = em.find(User.class, oldUser.getUserId());
		
		em.getTransaction().begin();
		result.setAddress(newUser.getAddress());
		result.setEmail(newUser.getEmail());
		result.setPassword(newUser.getPassword());
		result.setSales(newUser.getSales());
		em.getTransaction().commit();
		
		return result;
		
	}
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = EMFSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, id);
		
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}
	
	

}
