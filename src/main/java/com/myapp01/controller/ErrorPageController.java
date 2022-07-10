package com.myapp01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * エラーページコントローラ
 * SimpleErrorControllerから呼ばれる
 */
@Controller
public class ErrorPageController {
	/**
	 * エラー時のアクション
	 * @return　ビュー名
	 */
	@GetMapping("/errorpage")
	private String login() {
		return "error/error";
	}
}
