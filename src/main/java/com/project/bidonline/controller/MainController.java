package com.project.bidonline.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		return "/index";
	}
	@RequestMapping("/user")
	public String userHome() {
		return "/user/bids";
	}
	@RequestMapping("/user/bids")
	public String bid() {
		return "/user/bids";
	}
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "/user/bids";
		}
		return "/user/login";
	}
	
}
