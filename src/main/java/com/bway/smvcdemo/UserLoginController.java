package com.bway.smvcdemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserLoginController {
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String loginPage(){
		
		return "login";
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String checkLogin(HttpServletRequest req, HttpServletResponse resp){
		
		String uname = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(uname.equals("admin") && password.equals("admin")){
			return "home";
		}
		
		return "login";
	}

}
