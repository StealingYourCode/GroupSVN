package com.fdmgroup.droplocker2.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DL2Controller {
	
	@RequestMapping(value={"/", "/HomePage"})
	public String goToHome() {
		return "HomePage";
	}

}
