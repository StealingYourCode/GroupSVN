package com.fdmgroup.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.chocolatestore.entities.Product;
import com.fdmgroup.chocolatestore.entities.ProductSale;
import com.fdmgroup.chocolatestore.entities.User;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

@Controller
@SessionAttributes("saleList")
public class CSController {

	@Autowired
	private ServletContext context;
		
	@RequestMapping("/")
	public String goToHome() {
		
		return "csFrontPage";
	}
	
	@ModelAttribute("saleList")
	public List<ProductSale> addList() {
		List<ProductSale> saleList = new ArrayList<ProductSale>(); //TODO use spring here!
		return saleList;
	}
	
	@RequestMapping("/cart")
	public String addToCart(@RequestParam String candy, Model model) {
		Map<String, Object> modelMap = model.asMap();
		List<ProductSale> saleList = (List<ProductSale>) modelMap.get("saleList");
		ProductSale ps = (ProductSale) ContextSingleton.getSpring().getBean("ProductSale");//TODO use spring here!!!
		List<Product> productList = (List<Product>) context.getAttribute("productList");
		for(ProductSale proSale : saleList){ 
			if (proSale.getProduct().getProductName().equals(candy)){
				proSale.setQuantity(proSale.getQuantity()+1);
				modelMap.put("saleList", saleList);
				return "csFrontPage";}
		}
		for(Product product : productList)
			if (product.getProductName().equals(candy)){
				ps.setProduct(product);
				ps.setQuantity(1);
				saleList.add(ps);
				modelMap.put("saleList", saleList);}
		return "csFrontPage";
	}
	
	@ModelAttribute("cartQty")
	public int calculateCart(Model model){
		int qty = 0;
		Map modelMap = model.asMap();
		List<ProductSale> saleList = (List<ProductSale>) modelMap.get("saleList");
		for(ProductSale ps : saleList) {
			
			qty = qty + ps.getQuantity(); 
			}
		return qty;
	}
	
	@RequestMapping("/csRegister")
	public String goToRegister(Model model) {
		model.addAttribute("user", new User());
		return "csRegister";
	}

}

