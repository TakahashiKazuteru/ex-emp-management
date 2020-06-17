package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報を操作するコントローラー.
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
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() { 
		return "administrator/insert";
	}
	
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form,BindingResult br) {
		if(br.hasErrors()) {
			return toInsert();
		}
		Administrator administrator = new Administrator();
		
		return "redirect:/";
	}
}
