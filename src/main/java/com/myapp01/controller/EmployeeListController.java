package com.myapp01.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
//		File file = new File(
//				"C:\\home\\software\\sts-4.15.1.RELEASE\\myapp01\\src\\main\\resources\\static\\temp\\hyoshi.pdf");
//
//		BufferedInputStream input = null;
//		OutputStream out = null;
//		try {
//      response.setContentType("application/pdf");
//      response.setHeader("Content-Disposition", "inline;");
//			input = new BufferedInputStream(new FileInputStream(file));
//			out = response.getOutputStream();
//			byte[] bytes = new byte[1024];
//			int read = 0;
//			while ((read = input.read(bytes, 0, bytes.length)) != -1) {
//				out.write(bytes, 0, read);
//			}
//			out.flush();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (input != null) {
//				try {
//					input.close();
//				} catch (IOException e) {
//					System.err.println(e);
//				}
//			}
//			if (out != null) {
//				try {
//					out.close();
//				} catch (IOException e) {
//					System.err.println(e);
//				}
//			}
//		}
//		return null;
		
		List<String> words = new ArrayList<>();
		words.add("漢字");
		words.add("①キロ");
		mav.addStaticAttribute("wordList", words);
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
