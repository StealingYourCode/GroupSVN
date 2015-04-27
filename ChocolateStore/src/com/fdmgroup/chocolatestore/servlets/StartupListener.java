package com.fdmgroup.chocolatestore.servlets;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fdmgroup.chocolatestore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;
import com.fdmgroup.chocolatestore.singleton.EMFSingleton;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
	
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent scEvent) {
    	
    	scEvent.getServletContext().getDefaultSessionTrackingModes().clear();
    	EMFSingleton.getInstance();
    	System.out.println("one");
    	
    	ProductDAO dao = new ProductDAO();//(ProductDAO) ContextSingleton.getSpring().getBean("ProductDAO");
    	System.out.println("two");
    	List<Product> productList = dao.readAll();
    	System.out.println("three");
    	scEvent.getServletContext().setAttribute("productList", productList);
    	System.out.println("four");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent scEvent) {
        EMFSingleton.getInstance().close();
        scEvent.getServletContext().getDefaultSessionTrackingModes().clear();
    }
	
}
