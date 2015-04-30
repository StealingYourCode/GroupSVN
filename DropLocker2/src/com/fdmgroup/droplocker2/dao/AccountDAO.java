package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManager;

import com.fdmgroup.droplocker2.entities.Account;
import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public class AccountDAO extends Storage<Account, Integer> {

	EntityManager em;
	
	@Override
	public Account create(Account account) throws StorableNotFoundException,
			StorableNullException {
		if(account!=null){
			em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			em.close();
		}
		throw new StorableNullException("Attempted to create User File of null value");
	}

	@Override
	public Account read(Integer ID) throws StorableNotFoundException {
		em = emf.createEntityManager();
		Account account = em.find(Account.class, ID);
		em.close();
		return account;
	}

	@Override
	public Account update(Account oldAccount, Account newAccount)
			throws StorableNotFoundException {
		em = emf.createEntityManager();
		if (oldAccount != null && newAccount != null) {
			em.getTransaction().begin();
			Account result = em.find(Account.class, oldAccount.getAccountId());
			
			em.close();
			return result;
		} else
			throw new StorableNotFoundException(oldAccount.getPlan()
					+ " was not found in our database");
	}
  
	@Override
	public void delete(Integer ID) throws StorableNotFoundException {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Account.class, ID));
		em.getTransaction().commit();
		em.close();
	}


}
