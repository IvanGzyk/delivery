package com.gzyk.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	//  comentário de uma linha
	/*
	 * comentáario de múltiplas linhas...
	 */
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello world!";
	}

}