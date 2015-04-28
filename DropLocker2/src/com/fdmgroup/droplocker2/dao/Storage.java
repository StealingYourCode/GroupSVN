package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManagerFactory;

import com.fdmgroup.droplocker2.exceptions.StorableNotFoundException;
import com.fdmgroup.droplocker2.exceptions.StorableNullException;

public abstract class Storage <T,I>{
	
	EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
	
	public abstract T create (T t) throws StorableNotFoundException, StorableNullException;  
	public abstract T read (I i) throws StorableNotFoundException;
	public abstract T update(T t, T y) throws StorableNotFoundException;
	public abstract void delete(I i) throws StorableNotFoundException;

}
