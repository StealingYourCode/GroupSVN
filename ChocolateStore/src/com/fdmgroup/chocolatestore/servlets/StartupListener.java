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
    	System.out.println("got here");
    	EMFSingleton.getInstance();
    	
    	//scEvent.getServletContext().getDefaultSessionTrackingModes().clear();
    	
    	ProductDAO dao = (ProductDAO) ContextSingleton.getSpring().getBean("ProductDAO");
    	List<Product> productList = dao.readAll();
    	scEvent.getServletContext().setAttribute("productList", productList);
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        EMFSingleton.getInstance().close();
    }
	
}
