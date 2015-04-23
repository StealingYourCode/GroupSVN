package com.fdmgroup.chocolatestore.interfaces;

public interface IStorage <T, I> {

	public T read(I i);
	
	public T create(T t);
	
	public T update(T t, T a);
	
	public void delete(I i);
}
