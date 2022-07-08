package com.myapp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.myapp01.form.UserForm;
import com.myapp01.service.UserListService;

@Controller
public class LoginController {
	
	@Autowired
	UserListService userListService;
	
	@GetMapping("/login")
	private String login(UserForm userForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
		}
		return "login/login";
	}
	
}
