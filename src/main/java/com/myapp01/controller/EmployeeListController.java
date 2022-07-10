package com.myapp01.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp01.common.Constants;
import com.myapp01.form.EmployeeListForm;
import com.myapp01.pdf.EmployeePdfView;
import com.myapp01.service.EmployeeListService;

/**
 * 社員情報検索コントローラ
 */
@Controller
public class EmployeeListController {

	// 社員情報検索サービス
	@Autowired
	EmployeeListService employeeListService;

	// セッション
	@Autowired
	HttpSession session; 

	/**
	 * 初期表示
	 * @param model モデル
	 * @return ビュー名
	 */
	@GetMapping("/list/init")
	private String init(Model model) {
		model.addAttribute("employeeListForm", new EmployeeListForm());
		model.addAttribute("genderList", Constants.GENDER_LIST);
		model.addAttribute("bloodTypeList", Constants.BLOOD_TYPE_LIST);
		
		return "list/list";
	}

	/**
	 * 検索
	 * @param employeeListForm 社員情報検索フォーム
	 * @param result　バリデーション結果
	 * @param model モデル
	 * @return ビュー名
	 */
	@PostMapping("/list/search")
	private String search(@Validated EmployeeListForm employeeListForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "list/list";
		}

		employeeListService.search(employeeListForm);

		model.addAttribute("employeeListForm", employeeListForm);
		model.addAttribute("genderList", Constants.GENDER_LIST);
		model.addAttribute("bloodTypeList", Constants.BLOOD_TYPE_LIST);
		
		session.setAttribute("employeeListForm", employeeListForm);
		
		return "list/list";
	}

	/**
	 * 全社員情報のPDF生成
	 * @param pdfView PDFビュー
	 * @return PDFビュー
	 */
	@PostMapping("/list/download")
	private EmployeePdfView download(EmployeePdfView pdfView) {
		EmployeeListForm employeeListForm = new EmployeeListForm();
		employeeListService.search(employeeListForm);
		pdfView.addStaticAttribute("employeeList", employeeListForm.getEmployeeList());
		return pdfView;
	}
	
	/**
	 * 検索（社員情報更新画面からの戻り用）
	 * @param model モデル
	 * @return　ビュー名
	 */
	@PostMapping("/list/back")
	private String back(Model model) {
		EmployeeListForm employeeListForm = (EmployeeListForm)session.getAttribute("employeeListForm");
		employeeListService.search(employeeListForm);

		model.addAttribute("employeeListForm", employeeListForm);
		model.addAttribute("genderList", Constants.GENDER_LIST);
		model.addAttribute("bloodTypeList", Constants.BLOOD_TYPE_LIST);
		return "list/list";
	}
}
