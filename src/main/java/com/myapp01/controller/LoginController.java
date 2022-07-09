package com.myapp01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	private String login() {
		return "login/login";
	}
	
  @PostMapping("/eroor")
  public String getLoginError(Model model) {
  	model.addAttribute("ErrorMessage","ユーザー名もしくはパスワードが一致しません");
  	return "login/login";
  }
}
