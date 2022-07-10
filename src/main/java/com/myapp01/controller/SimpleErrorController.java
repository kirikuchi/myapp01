package com.myapp01.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * エラーコントローラ
 * HTTP 404, 405等の発生時に呼ばれる
 */
@Controller
@RequestMapping("/error")
public class SimpleErrorController implements ErrorController {
	/**
	 * エラー時のアクション
	 * @param req リクエスト
	 * @param mav モデルビュー
	 * @return モデルビュー
	 */
	@RequestMapping
	public ModelAndView error(HttpServletRequest req, ModelAndView mav) {
		// 不正なリクエストは全部404にする
		mav.setStatus(HttpStatus.NOT_FOUND);
		// エラーページにフォワードする
		mav.setViewName("forward:/errorpage");
		return mav;
	}
}
