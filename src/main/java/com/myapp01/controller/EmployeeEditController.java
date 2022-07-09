package com.myapp01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp01.form.EmployeeEditForm;
import com.myapp01.service.EmployeeEditService;

@Controller
public class EmployeeEditController {

	@Autowired
	EmployeeEditService employeeEditService;

	@PostMapping("/edit/init")
	private String init(@RequestParam("hdnSelectedEmpId") String hdnSelectedEmpId, Model model) {
		EmployeeEditForm employeeEditForm = new EmployeeEditForm();
		employeeEditService.searchById(hdnSelectedEmpId, employeeEditForm);
		
		model.addAttribute("employeeEditForm", employeeEditForm);
		model.addAttribute("genderList", getGenderList());
		model.addAttribute("bloodTypeList", getBloodTypeList());
		
		return "edit/edit";
	}

	@PostMapping("/edit/update")
	private String update(@Validated EmployeeEditForm employeeEditForm, BindingResult result, Model model) {
		model.addAttribute("genderList", getGenderList());
		model.addAttribute("bloodTypeList", getBloodTypeList());
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "edit/edit";
		}
		employeeEditService.update(employeeEditForm);
		
		return "forward:/list/back";
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
