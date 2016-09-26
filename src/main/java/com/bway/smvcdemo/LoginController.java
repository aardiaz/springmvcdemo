package com.bway.smvcdemo;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.smvcdemo.daos.StudentDao;
import com.bway.smvcdemo.daos.UserDao;
import com.bway.smvcdemo.models.User;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model, HttpSession session){
		
		logger.info("inside login page method");
		
		if (StringUtils.isEmpty(session.getAttribute("username"))) {
			return "redirect:/login";
		}
		
		model.addAttribute("studentList", studentDao.getAll());
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String  validateLogin(@ModelAttribute User user, Model model,HttpSession session){
		
	  ///	HttpSession se = req.getSession();//for jsp servlet
		if(userDao.validateUser(user)){
			logger.info("login success");
			
			session.setAttribute("username", user.getUsername());
			session.setMaxInactiveInterval(10*60);
			
			model.addAttribute("studentList", studentDao.getAll());
			
			return "home";
		}
		
		logger.info("login failed");
		return "login";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "login";
	}

}
