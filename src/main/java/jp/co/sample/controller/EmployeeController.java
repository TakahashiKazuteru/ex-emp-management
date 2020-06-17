package jp.co.sample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 社員情報を操作するコントローラー.
 * 
 * @author kazuteru.takahashi
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private EmployeeService service;
	
	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 社員一覧画面を表示する.
	 * 
	 * @param model リクエストスコープ
	 * @return 社員一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> employeeList = service.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}
	
	/**
	 * 社員詳細画面の表示.
	 * 
	 * @param id ID
	 * @param model リクエストスコープ
	 * @return 社員詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		Employee employee = service.showDetail(Integer.parseInt(id));
		model.addAttribute("employee",employee);
		System.out.println(employee);
		return "employee/detail";
	}
	
	/**
	 * 社員情報(扶養人数情報)の更新
	 * 
	 * @param form IDと扶養人数のフォーム
	 * @param br validation用
	 * @param model リクエストスコープ
	 * @return 社員一覧画面を表示
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		Employee employee = service.showDetail(Integer.parseInt(form.getId()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		service.update(employee);
		return "redirect:/employee/showList";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

}
