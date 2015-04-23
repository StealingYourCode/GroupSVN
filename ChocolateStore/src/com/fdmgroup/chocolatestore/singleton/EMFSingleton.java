package com.fdmgroup.chocolatestore.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	
	private static EntityManagerFactory instance = null;
	
	private EMFSingleton(){
		
	}
	
	public static EntityManagerFactory getInstance(){
		
		if(instance==null)
			instance = Persistence.createEntityManagerFactory("ChocolateStore");
		
		return instance;
		
		
	}

}
