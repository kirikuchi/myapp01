package com.myapp01.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp01.common.Constants;
import com.myapp01.form.EmployeeEditForm;
import com.myapp01.form.EmployeeListForm;
import com.myapp01.service.EmployeeEditService;

/**
 * 社員情報更新コントローラ
 */
@Controller
public class EmployeeEditController {

	// 社員情報更新サービス
	@Autowired
	EmployeeEditService employeeEditService;

	// セッション
	@Autowired
	HttpSession session; 
	
	/**
	 * 初期表示
	 * @param hdnSelectedEmpId　社員ID
	 * @param hdnScrollTop 検索結果のスクロールバーの位置
	 * @param model モデル
	 * @return ビュー名
	 */
	@PostMapping("/edit/init")
	private String init(@RequestParam("hdnSelectedEmpId") String hdnSelectedEmpId, @RequestParam("hdnScrollTop") String hdnScrollTop, Model model) {
		EmployeeListForm employeeListForm = (EmployeeListForm)session.getAttribute("employeeListForm");
		employeeListForm.setHdnScrollTop(hdnScrollTop);
		session.setAttribute("employeeListForm", employeeListForm);
		
		EmployeeEditForm employeeEditForm = new EmployeeEditForm();
		employeeEditService.searchById(hdnSelectedEmpId, employeeEditForm);
		
		model.addAttribute("employeeEditForm", employeeEditForm);
		model.addAttribute("genderList", Constants.GENDER_LIST);
		model.addAttribute("bloodTypeList", Constants.BLOOD_TYPE_LIST);
		
		return "edit/edit";
	}

	/**
	 * 更新
	 * @param employeeEditForm 社員情報更新フォーム
	 * @param result バリデーション結果
	 * @param model モデル
	 * @return ビュー名
	 */
	@PostMapping("/edit/update")
	private String update(@Validated EmployeeEditForm employeeEditForm, BindingResult result, Model model) {
		model.addAttribute("genderList", Constants.GENDER_LIST);
		model.addAttribute("bloodTypeList", Constants.BLOOD_TYPE_LIST);
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "edit/edit";
		}
		employeeEditService.update(employeeEditForm);
		
		return "forward:/list/back";
	}
}
