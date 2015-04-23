package com.fdmgroup.chocolatestore.interfaces;

import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;

public interface IStorage <T, I> {

	public T read(I i) throws StorableNotFoundException, NullInputException;
	
	public T create(T t) throws StorableNotFoundException;
	
	public T update(T t, T a)throws StorableNotFoundException;
	
	public void delete(I i)throws StorableNotFoundException;
}
