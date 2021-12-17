package com.application.TestJavaApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RedirectController {

	
	@RequestMapping("/")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}
