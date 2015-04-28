package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManager;

import com.fdmgroup.droplocker2.entities.UserFile;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class UserFileDAO extends Storage<UserFile, Integer> {

	EntityManager em;

	@Override
	public UserFile create(UserFile userFile) throws StorableNotFoundException,
			StorableNullException {
		if (userFile != null) {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(userFile);
			em.getTransaction().commit();
			em.close();
			return userFile;
		}
		throw new StorableNullException(
				"Attempted to create User File of null value");
	}

	@Override
	public UserFile read(Integer ID) throws StorableNotFoundException {
		em = emf.createEntityManager();
		UserFile userfile = em.find(UserFile.class, ID);
		em.close();
		return userfile;
	}

	@Override
	public UserFile update(UserFile oldUserFile, UserFile newUserFile)
			throws StorableNotFoundException {
		em = emf.createEntityManager();
		if (oldUserFile != null && newUserFile != null) {
			em.getTransaction().begin();
			UserFile result = em.find(UserFile.class, oldUserFile.getUserId());
			result.setFileName(newUserFile.getFileName());
			result.setUserId(newUserFile.getUserId());
			em.close();
			return result;
		} else
			throw new StorableNotFoundException(oldUserFile.getFileName()
					+ " was not found in our database");
	}

	@Override
	public void delete(Integer ID) throws StorableNotFoundException {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(UserFile.class, ID));
		em.getTransaction().commit();
		em.close();

	}

}
