package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.fdmgroup.droplocker2.entities.User;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class UserDAO extends Storage<User, Integer> {

	EntityManager em;

	@Override
	public User create(User user) throws StorableNotFoundException,
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
	public User read(Integer ID) throws StorableNotFoundException {

		em = emf.createEntityManager();
		User user = em.find(User.class, ID);
		em.close();
		return user;
	}

	public User read(String username) throws StorableNotFoundException {
		em = emf.createEntityManager();
		Query query = em.createNativeQuery(
				"select * from user where username = '" + username + "'",
				User.class);
		User user;
		try {
			user = (User) query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new StorableNotFoundException("User not found");
		} finally {
			em.close();
		}
	}

	@Override
	public User update(User oldUser, User newUser)
			throws StorableNotFoundException {
		em = emf.createEntityManager();
		if (oldUser != null && newUser != null) {
			em.getTransaction().begin();
			User result = em.find(User.class, oldUser.getUserId());
			result.setPassword(newUser.getPassword());
			result.setUsername(newUser.getUsername());
			result.setUserPlan(newUser.getUserPlan());
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
		em.remove(em.find(User.class, ID));
		em.getTransaction().commit();
		em.close();
	}

}
