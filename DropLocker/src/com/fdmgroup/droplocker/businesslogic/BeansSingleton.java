package com.fdmgroup.droplocker.businesslogic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansSingleton {

	private static ApplicationContext context;

	private BeansSingleton(){}

	public static ApplicationContext getSpring(){
		if (context == null)
			context = new ClassPathXmlApplicationContext("Beans.xml");
		return context;
	}

}
