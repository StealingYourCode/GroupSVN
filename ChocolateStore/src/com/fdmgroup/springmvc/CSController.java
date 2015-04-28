package com.fdmgroup.springmvc;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.chocolatestore.entities.Product;
import com.fdmgroup.chocolatestore.entities.ProductSale;
import com.fdmgroup.chocolatestore.entities.User;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

@Controller
@SessionAttributes("saleList")
public class CSController {

	@Autowired
	private ServletContext context;
		
	@RequestMapping(value={"/", "/csFrontPage"})
	public String goToHome(Model model) {
		addList(model);
		return "csFrontPage";
	}
	
	@ModelAttribute("saleList")
	public List<ProductSale> addList(Model model) {
		Map<String, Object> modelMap = model.asMap();
		List<ProductSale> saleList = (List<ProductSale>) modelMap.get("saleList");
		if ( saleList == null);
			saleList = (List<ProductSale>) ContextSingleton.getSpring().getBean("psList");
		return saleList;
	}
	
	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam String candy, Model model) {
		Map<String, Object> modelMap = model.asMap();
		List<ProductSale> saleList = (List<ProductSale>) modelMap.get("saleList");
		ProductSale ps = (ProductSale) ContextSingleton.getSpring().getBean("ProductSale");
		List<Product> productList = (List<Product>) context.getAttribute("productList");
		for(ProductSale proSale : saleList){ 
			if (proSale.getProduct().getProductName().equals(candy)){
				proSale.setQuantity(proSale.getQuantity()+1);
				modelMap.put("saleList", saleList);
				model.addAttribute("cartQty", calculateCart(model));
				return "csFrontPage";}
		}
		for(Product product : productList)
			if (product.getProductName().equals(candy)){
				ps.setProduct(product);
				ps.setQuantity(1);
				saleList.add(ps);
				modelMap.put("saleList", saleList);
				model.addAttribute("cartQty", calculateCart(model));
				}
		return "csFrontPage";
	}
	
	
	public int calculateCart(Model model){
		int qty = 0;
		Map modelMap = model.asMap();
		List<ProductSale> saleList = (List<ProductSale>) modelMap.get("saleList");
		for(ProductSale ps : saleList) {
			
			qty = qty + ps.getQuantity(); 
			}
		return qty;
	}
	
	@RequestMapping("/csCartReview")
	public String goTocart() {
		return "csCartReview";
	}
	
	@RequestMapping("remove")
	public String remove(@RequestParam String candy, Model model) {
		Map modelMap = model.asMap();
		List<ProductSale> saleList = (List<ProductSale>) modelMap.get("saleList");
		for (ProductSale proSale : saleList)
			if (proSale.getProduct().getProductName().equals(candy)) {
				saleList.remove(proSale);
				modelMap.put("saleList", saleList);
				return "csCartReview";}

		return "csCartReview";
	}

	@RequestMapping("/purchase")
	public String makePurchase(Model model) {
		BusinessLogic bizLog = new BusinessLogic();// ((BusinessLogic)
		// ContextSingleton.getSpring().getBean("BusinessLogic"));
		Map<String, Object> modelMap = model.asMap();
		List<ProductSale> purchaseList = (List<ProductSale>) modelMap.get("saleList");
		if (purchaseList.isEmpty())
			model.addAttribute("zero", "of nothing....");
		for (ProductSale proSale : purchaseList) {
			bizLog.purchase(proSale.getProduct().getProductName(), proSale.getQuantity(), "email@email.com");
		}
		String message = "Thank You For Your Purchase!!";
		model.addAttribute("success", message);
		modelMap.remove("saleList");
		return "csCartReview";
	}

}