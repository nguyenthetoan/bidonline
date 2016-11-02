package com.project.bidonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login() {
		return "/user/login";
	}
	@RequestMapping(value = "/user/bids", method = RequestMethod.GET)
	public String bids() {
		return "/user/bids";
	}
}
