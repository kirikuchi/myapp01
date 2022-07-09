package com.myapp01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {
	@GetMapping("/errorpage")
	private String login() {
		return "error/error";
	}
}
