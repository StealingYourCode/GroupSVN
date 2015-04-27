package com.fdmgroup.springmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fdmgroup.chocolatestore.entities.Product;
import com.fdmgroup.chocolatestore.entities.ProductSale;
import com.fdmgroup.chocolatestore.entities.User;
import com.fdmgroup.chocolatestore.exceptions.NullInputException;
import com.fdmgroup.chocolatestore.exceptions.StorableNotFoundException;
import com.fdmgroup.chocolatestore.singleton.ContextSingleton;

@Controller
@SessionAttributes(value={"saleList", "loggedIn"})
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
			saleList = new ArrayList<ProductSale>();//(List<ProductSale>) ContextSingleton.getSpring().getBean("psList");
		return saleList;
	}
	
	@RequestMapping("/addToCart")
	public String addToCart(@RequestParam String candy, Model model) {
		Map<String, Object> modelMap = model.asMap();
		List<ProductSale> saleList = (List<ProductSale>) modelMap.get("saleList");
		ProductSale ps = new ProductSale();//(ProductSale) ContextSingleton.getSpring().getBean("ProductSale");
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
				modelMap.put("saleList", saleList);
				}
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
	
	@RequestMapping("/registerUser")
	@ModelAttribute("loggedIn")
	public String addUser(User user){
		if (user != null)
			new BusinessLogic().register(user);//((BusinessLogic) ContextSingleton.getSpring().getBean("BusinessLogic")).register(user);
		return "csFrontPage";
	}
	
	@RequestMapping("/csLogin")
	public String goToLogin() {
		return "csLogin";
	}
	
	@RequestMapping(value="/LoginUser")
	public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
		System.out.println("Logging in");
		try {
			System.out.println("attemting to create");
			BusinessLogic bizLog = new BusinessLogic();
			System.out.println("before");
			User user = bizLog.login(email, password);//((BusinessLogic) ContextSingleton.getSpring().getBean("BusinessLogic")).Login(email, password);
			System.out.println("created user");
			model.addAttribute("loggedIn", user);
			System.out.println("added user");
		} catch (NullInputException e) {
			e.printStackTrace();
			return "csLogin";
		} catch (StorableNotFoundException e) {
			e.printStackTrace();
			return "csRegister";
		}
		return "csFrontPage";
	}
	
	@RequestMapping("/csCartReview")
	public String goToCart() {
		return "csCartReview";
	}

	
	@RequestMapping("/logout")
	public String logOutUser(HttpSession session){
		
		session.invalidate();
		
		return "csFrontPage";
		
	}

	
	@RequestMapping("/purchase")
	public String makePurchase(Model model) {
		BusinessLogic bizLog = new BusinessLogic();//((BusinessLogic) ContextSingleton.getSpring().getBean("BusinessLogic"));
		Map<String, Object> modelMap = model.asMap();
		List<ProductSale> purchaseList = (List<ProductSale>) modelMap.get("saleList");
		for (ProductSale proSale : purchaseList) {
			try {
				bizLog.purchase(proSale.getProduct().getProductName(), proSale.getQuantity(), ((User)modelMap.get("loggedIn")).getEmail());
			} catch (NullInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		modelMap.remove("saleList");
		return "csSuccess";
	}
	
	


}

