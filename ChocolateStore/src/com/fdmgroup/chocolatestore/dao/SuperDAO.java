package com.fdmgroup.chocolatestore.dao;

import javax.persistence.EntityManagerFactory;

import com.fdmgroup.chocolatestore.singleton.EMFSingleton;

public class SuperDAO {
	EntityManagerFactory emf = EMFSingleton.getInstance();
	
}
