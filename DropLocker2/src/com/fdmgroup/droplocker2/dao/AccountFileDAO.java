package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManager;

import com.fdmgroup.droplocker2.entities.AccountFile;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class AccountFileDAO extends Storage<AccountFile, Integer> {

	EntityManager em;

	@Override
	public AccountFile create(AccountFile accountFile) throws StorableNotFoundException,
			StorableNullException {
		if (accountFile != null) {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(accountFile);
			em.getTransaction().commit();
			em.close();
			return accountFile;
		}
		throw new StorableNullException(
				"Attempted to create User File of null value");
	}

	@Override
	public AccountFile read(Integer ID) throws StorableNotFoundException {
		em = emf.createEntityManager();
		AccountFile userfile = em.find(AccountFile.class, ID);
		em.close();
		return userfile;
	}

	@Override
	public AccountFile update(AccountFile oldUserFile, AccountFile newUserFile)
			throws StorableNotFoundException {
		em = emf.createEntityManager();
		if (oldUserFile != null && newUserFile != null) {
			em.getTransaction().begin();
			AccountFile result = em.find(AccountFile.class, oldUserFile.getAccountId());
			result.setFileName(newUserFile.getFileName());
			result.setAccountId(newUserFile.getAccountId());
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
		em.remove(em.find(AccountFile.class, ID));
		em.getTransaction().commit();
		em.close();

	}

}
