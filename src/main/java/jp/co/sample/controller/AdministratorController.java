package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * ログイン・管理者登録リクエストを受けるコントローラー.
 * 
 * @author kazuteru.takahashi
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService service;
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}
	
	/**
	 * ログイン画面をレスポンスする.
	 * @return ログイン画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() { 
		return "administrator/insert";
	}
}
