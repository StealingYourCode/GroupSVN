package com.fdmgroup.droplocker2.businesslogic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanSingleton {
	
	private static ApplicationContext context;
	
	private BeanSingleton() {}
	
	public static ApplicationContext getSpring(){
		if(context == null)
			context = new ClassPathXmlApplicationContext("beans.xml");
		return context;
	}
	
}
