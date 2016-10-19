package com.first.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public ModelAndView showMessage() { 
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("displayMsg", "Welcome To WareHouse App.");
		return mv;
	}

}
