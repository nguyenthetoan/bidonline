package com.project.bidonline.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Params;
import com.project.bidonline.authenticate.LoggedUser;
import com.project.bidonline.entity.User;

@Controller
@SessionAttributes("loggedUser")
public class MainController {
	
	@ModelAttribute("loggedUser")
	public LoggedUser getLogedUser() {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
			return new LoggedUser();
		}
		return (LoggedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@RequestMapping("/")
	public String home(Model model, HttpServletRequest request, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("message",name);
		System.out.println("=====session======");
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(e);
			System.out.println("Session attributes: "+session.getAttribute(s));
		}
		return "/index";
	}
	@RequestMapping("/user/bids")
	public String bid() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "/user/bids";
		}
		return "/user/login";
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
