package com.myapp01.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp01.form.UserForm;
import com.myapp01.service.UserListService;

@Controller
public class UserListController {

	@Autowired
	UserListService userListService;

	@GetMapping("/list")
	private String init(UserForm userForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
		}
		return "list/list";
	}

	@PostMapping("/list/search")
	private String search(@Validated UserForm userForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "list/list";
		}

		userListService.search();

		userForm.setAge(userForm.getAge().add(new BigDecimal(1)));
		model.addAttribute("userForm", userForm);
		return "list/list";
	}

	@PostMapping("/list/download")
	private String download(@RequestParam("name") String name, HttpServletResponse response) {
		System.out.println("name: " + name);
		File file = new File(
				"C:\\home\\software\\sts-4.15.1.RELEASE\\myapp01\\src\\main\\resources\\static\\temp\\hyoshi.pdf");

		BufferedInputStream input = null;
		OutputStream out = null;
		try {
      response.setContentType("application/pdf");
      response.setHeader("Content-Disposition", "inline;");
			input = new BufferedInputStream(new FileInputStream(file));
			out = response.getOutputStream();
			byte[] bytes = new byte[1024];
			int read = 0;
			while ((read = input.read(bytes, 0, bytes.length)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
		return null;
	}
}
