package com.fdmgroup.chocolatestore.dao;

import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.chocolatectore.entities.User;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.interfaces.IStorable;
import com.fdmgroup.chocolatestore.interfaces.IStorage;
import com.fdmgroup.chocolatestore.singleton.EMFSingleton;

public class UserDAO extends SuperDAO implements IStorage<User, Integer>{

	@Override
	public User read(Integer id) throws StorableNotFoundException {
		
		User user = em.find(User.class, id);
		
		if(user==null)
			throw new StorableNotFoundException("This user was not found");
		
		return  user;
	}

	@Override
	public User create(User user) throws StorableNotFoundException{

		
		if(user==null)
			throw new StorableNotFoundException("This user was not found");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		return user;
	}

	@Override
	public User update(User oldUser, User newUser)throws StorableNotFoundException {
		
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
		
		User user = em.find(User.class, id);
		
		if(user==null)
			throw new StorableNotFoundException("This user was not found");
		
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}
	
	

}
