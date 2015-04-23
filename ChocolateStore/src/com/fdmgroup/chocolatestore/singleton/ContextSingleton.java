package com.fdmgroup.chocolatestore.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextSingleton {
	
	private static ApplicationContext context;
	
	private ContextSingleton(){}
	
	public static ApplicationContext getSpring(){
		if (context == null)
			context = new ClassPathXmlApplicationContext("Beans.xml");
		return context;
	}
}
