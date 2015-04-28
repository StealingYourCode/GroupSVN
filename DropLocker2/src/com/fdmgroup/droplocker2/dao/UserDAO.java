package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.fdmgroup.droplocker2.entities.Customer;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class UserDAO extends Storage<Customer, Integer> {

	EntityManager em;

	@Override
	public Customer create(Customer user) throws StorableNotFoundException,
			StorableNullException {
		if (user != null) {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
			return user;
		}
		throw new StorableNullException(
				"Attempted to create user of null value");
	}

	@Override
	public Customer read(Integer ID) throws StorableNotFoundException {

		em = emf.createEntityManager();
		Customer user = em.find(Customer.class, ID);
		em.close();
		return user;
	}

	public Customer read(String username) throws StorableNotFoundException {
		em = emf.createEntityManager();
		Query query = em.createNativeQuery(
				"select * from user where username = '" + username + "'",
				Customer.class);
		Customer user;
		try {
			user = (Customer) query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new StorableNotFoundException("User not found");
		} finally {
			em.close();
		}
	}

	@Override
	public Customer update(Customer oldUser, Customer newUser)
			throws StorableNotFoundException {
		em = emf.createEntityManager();
		if (oldUser != null && newUser != null) {
			em.getTransaction().begin();
			Customer result = em.find(Customer.class, oldUser.getUserId());
			result.setPassword(newUser.getPassword());
			result.setUsername(newUser.getUsername());
			result.setUserAccount(newUser.getUserAccount());
			em.close();
			return result;
		} else
			throw new StorableNotFoundException(oldUser
					+ " was not found in our database");
	}

	@Override
	public void delete(Integer ID) throws StorableNotFoundException {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Customer.class, ID));
		em.getTransaction().commit();
		em.close();
	}

}
