package com.myapp01.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Web アプリケーション全体のエラーコントローラー。 ErrorController インターフェースの実装クラス。
 */
@Controller
@RequestMapping("/error") // エラーページへのマッピング
public class SimpleErrorController implements ErrorController {
	/**
	 * レスポンス用の ModelAndView オブジェクトを返す。
	 *
	 * @param req リクエスト情報
	 * @param mav レスポンス情報
	 * @return HTML レスポンス用の ModelAndView オブジェクト
	 */
	@RequestMapping
	public ModelAndView error(HttpServletRequest req, ModelAndView mav) {

		// 不正なリクエストは全部404にする
		mav.setStatus(HttpStatus.NOT_FOUND);

		// ビュー名を指定する
		mav.setViewName("forward:/errorpage");

		return mav;
	}
}
