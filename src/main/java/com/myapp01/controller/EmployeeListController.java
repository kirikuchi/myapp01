package com.myapp01.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp01.form.EmployeeListForm;
import com.myapp01.pdf.MyPdfView;
import com.myapp01.service.EmployeeListService;

@Controller
public class EmployeeListController {

	@Autowired
	EmployeeListService employeeListService;

	@Autowired
	HttpSession session; 
	 
	@GetMapping("/list/init")
	private String init(Model model) {
		model.addAttribute("employeeListForm", new EmployeeListForm());
		model.addAttribute("genderList", getGenderList());
		model.addAttribute("bloodTypeList", getBloodTypeList());
		
		return "list/list";
	}

	@PostMapping("/list/search")
	private String search(@Validated EmployeeListForm employeeListForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "list/list";
		}

		employeeListService.search(employeeListForm);

		model.addAttribute("employeeListForm", employeeListForm);
		model.addAttribute("genderList", getGenderList());
		model.addAttribute("bloodTypeList", getBloodTypeList());
		
		session.setAttribute("employeeListForm", employeeListForm);
		
		return "list/list";
	}

	@PostMapping("/list/download")
	private MyPdfView download(MyPdfView mav) {
		EmployeeListForm employeeListForm = new EmployeeListForm();
		employeeListService.search(employeeListForm);
		mav.addStaticAttribute("employeeList", employeeListForm.getEmployeeList());
		return mav;
		
	}
	
	@PostMapping("/list/back")
	private String back(Model model) {
		EmployeeListForm employeeListForm = (EmployeeListForm)session.getAttribute("employeeListForm");
		employeeListService.search(employeeListForm);
		
		model.addAttribute("employeeListForm", employeeListForm);
		model.addAttribute("genderList", getGenderList());
		model.addAttribute("bloodTypeList", getBloodTypeList());
		return "list/list";
	}
	
	private List<String> getGenderList () {
		List<String>list = new ArrayList<>();
		list.add("男");
		list.add("女");
		return list;
	}
	
	private List<String> getBloodTypeList () {
		List<String>list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("O");
		list.add("AB");
		return list;
	}
}
