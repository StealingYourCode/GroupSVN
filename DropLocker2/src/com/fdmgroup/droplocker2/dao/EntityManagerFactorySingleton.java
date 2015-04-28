package com.fdmgroup.droplocker2.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
		
		private static EntityManagerFactory instance = null;
		
		private EntityManagerFactorySingleton(){
			
		}
		
		public static EntityManagerFactory getInstance(){
			
			if(instance==null)
				instance = Persistence.createEntityManagerFactory("DropLocker2");
			
			return instance;
			
			
		}
}
