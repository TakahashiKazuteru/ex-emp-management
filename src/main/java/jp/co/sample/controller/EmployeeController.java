package jp.co.sample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.SearchEmployeeForm;
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
	public SearchEmployeeForm setUpSearchEmployeeFrom() {
		return new SearchEmployeeForm();
	}
	
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
		String administratorName = (String) session.getAttribute("administratorName");
		if(administratorName == null) {
			return "redirect:/";
		}
		List<Employee> employeeList = service.showList();
		model.addAttribute("employeeList", employeeList);
		return "employee/list";
	}
	
	@RequestMapping("/search")
	public String search(SearchEmployeeForm form,Model model) {
		List<Employee> employeeList = service.showNearNameList(form.getSearchName());
		model.addAttribute("employeeList",employeeList);
		model.addAttribute("searchWord",form.getSearchName());
		return "employee/list";
	}

	/**
	 * 社員詳細画面の表示.
	 * 
	 * @param id    ID
	 * @param model リクエストスコープ
	 * @return 社員詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		String administratorName = (String) session.getAttribute("administratorName");
		if(administratorName == null) {
			return "redirect:/";
		}
		Employee employee = service.showDetail(Integer.parseInt(id));
		model.addAttribute("employee", employee);
		return "employee/detail";
	}

	/**
	 * 社員情報(扶養人数情報)の更新.
	 * 
	 * @param form   IDと扶養人数のフォーム
	 * @param result validation用
	 * @param model  リクエストスコープ
	 * @return 社員一覧画面を表示
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateEmployeeForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return showDetail(form.getId(), model);
		}
		System.out.println("error = "+result.hasErrors());
		Employee employee = service.showDetail(Integer.parseInt(form.getId()));
		BeanUtils.copyProperties(form, employee);
		employee.setHireDate((form.getHireDate()));
		employee.setSalary(Integer.parseInt(form.getSalary()));
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		service.update(employee);
		return "redirect:/employee/showList";
	}

	/**
	 * ログアウトする.
	 * 
	 * @return ログイン画面を表示
	 */
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

}
