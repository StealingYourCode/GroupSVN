package com.fdmgroup.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.chocolatectore.entities.Product;
import com.fdmgroup.chocolatestore.dao.ProductDAO;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

@Controller
public class CSController {

	
	@RequestMapping("/")
	public String goToHome() {
		
		return "csFrontPage";
	}
	

	
	

	
	
}
