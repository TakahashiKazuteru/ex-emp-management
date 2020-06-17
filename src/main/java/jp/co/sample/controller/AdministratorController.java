package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
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
	private HttpSession session;
	
	@Autowired
	private AdministratorService service;

	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * ログイン画面の表示
	 * 
	 * @param model リクエストスコープ
	 * @return ログイン画面
	 */
	@RequestMapping("/")
	public String toLogin(Model model) {
		return "administrator/login";
	}

	/**
	 * ログイン処理を行う
	 * 
	 * @param form ログイン情報
	 * @param model リクエストスコープ
	 * @return ログイン成功ならば従業員一覧へ(失敗ならばログイン画面へ戻る)
	 */
	@RequestMapping("/login")
	public String login(LoginForm form,Model model) {
		
		Administrator administrator = service.findByMailaddressAndPassword(form.getMailAddress(), form.getPassword());
		if (administrator == null) {
			model.addAttribute("message", "メールアドレスまたはパスワードが不正です");
			return toLogin(model);
		}
		session.setAttribute("administratorName", administrator.getName());
		return "foward:/employee/showList";
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

	/**
	 * 入力された情報を登録する.
	 * 
	 * @param form 入力情報
	 * @param br   エラー情報
	 * @return ホーム画面(リダイレクト)
	 */
	@RequestMapping("/insert")
	public String insert(@Validated InsertAdministratorForm form, BindingResult br) {
		if (br.hasErrors()) {
			return toInsert();
		}
		Administrator administrator = new Administrator();
		BeanUtils.copyProperties(form, administrator);
		service.insert(administrator);

		return "redirect:/";
	}
}
