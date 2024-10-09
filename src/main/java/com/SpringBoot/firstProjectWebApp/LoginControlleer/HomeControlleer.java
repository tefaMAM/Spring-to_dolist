package com.SpringBoot.firstProjectWebApp.LoginControlleer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class HomeControlleer  {
	

	/*
	 value="/": This maps the root URL ("/") to the homePage method. 
	 When a user visits the root of your application, this method is invoked.
     method = RequestMethod.GET: This specifies that the method should only handle GET requests.
     GET requests are typically used to retrieve data, not modify it.  
	 */
	 @RequestMapping(value="/",method = RequestMethod.GET)
	    public String homePage(ModelMap model){
		 	model.addAttribute("username", this.getLoggedInUserName());
	        return "home";
	    }
	 public String getLoggedInUserName() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 return authentication.getName();
	 }
	
		 
	}

