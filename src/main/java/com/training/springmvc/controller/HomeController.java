package com.training.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.springmvc.model.User;
import com.training.springmvc.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="home" ,method=RequestMethod.GET)
	public String greet(Model map) {
		System.out.println("Inside controller method..");
		map.addAttribute("msg", "Hello From Spring MVC");
		return "home";
		
	}
	
	@RequestMapping(value="getUser" ,method=RequestMethod.GET)
	public String getVal(Model map, @RequestParam int userId) {
		
		User user = service.getUser(userId);
		System.out.println("User Name: "+user.getUserName());
		map.addAttribute("uId", user.getUserName());
		return "user";
		
	}
	@RequestMapping(value="getName/{name}" ,method=RequestMethod.GET)
	public String getName(Model map, @PathVariable String name, HttpServletRequest request) {
		System.out.println("User Name: "+name);
		map.addAttribute("name", name);
		return "username";
		
	}

}
