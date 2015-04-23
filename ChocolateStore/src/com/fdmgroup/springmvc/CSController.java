package com.fdmgroup.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.chocolatectore.entities.ProductSale;

@Controller
public class CSController {

	
	@RequestMapping("/")
	public String goToHome() {
		
		return "csFrontPage";
	}
	

	@RequestMapping("/cart")
	public String addToCart() {
		List<ProductSale> saleList = new ArrayList<ProductSale>(); //TODO use spring here!
		saleList.add(new ProductSale());
		return "csFrontPage";
	}

}
