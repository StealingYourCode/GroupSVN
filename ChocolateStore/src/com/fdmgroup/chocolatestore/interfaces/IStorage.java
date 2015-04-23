package com.fdmgroup.chocolatestore.interfaces;

public interface IStorage <T, I> {

	public IStorable read(I i);
	
	public IStorable create(T t);
	
	public IStorable update(T t, T a);
	
	public IStorable delete(I i);
}
