package com.fdmgroup.chocolatestore.dao;

import javax.persistence.EntityManager;

import com.fdmgroup.chocolatectore.entities.User;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.interfaces.IStorage;

public class UserDAO extends SuperDAO implements IStorage<User, Integer>{

	EntityManager em;
	@Override
	public User read(Integer id) throws StorableNotFoundException {
		em = emf.createEntityManager();
		User user = em.find(User.class, id);
		
		if(user==null)
			throw new StorableNotFoundException("This user was not found");
		
		return  user;
	}

	@Override
	public User create(User user) throws StorableNotFoundException{

		em = emf.createEntityManager();
		if(user==null)
			throw new StorableNotFoundException("This user was not found");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		return user;
	}

	@Override
	public User update(User oldUser, User newUser)throws StorableNotFoundException {
		em = emf.createEntityManager();
		if(oldUser==null || newUser==null)
			throw new StorableNotFoundException("This user was not found");
		
		User result = em.find(User.class, oldUser.getUserId());
		
		em.getTransaction().begin();
		result.setAddress(newUser.getAddress());
		result.setEmail(newUser.getEmail());
		result.setPassword(newUser.getPassword());
		result.setSales(newUser.getSales());
		em.getTransaction().commit();
		
		return result;
		
	}
	public void delete(Integer id) throws StorableNotFoundException{
		em = emf.createEntityManager();
		User user = em.find(User.class, id);
		
		if(user==null)
			throw new StorableNotFoundException("This user was not found");
		
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}
	
	

}
