package com.myapp01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログインコントローラ
 */
@Controller
public class LoginController {
	/**
	 * 初期表示
	 * @return ビュー名
	 */
	@GetMapping("/login")
	private String login() {
		return "login/login";
	}
	
	/**
	 * ログインエラー
	 * @param model モデル
	 * @return ビュー名
	 */
  @PostMapping("/loginerr")
  public String getLoginError(Model model) {
  	model.addAttribute("errorMessage", "ユーザー名もしくはパスワードが間違っています。");
  	return "login/login";
  }
}
