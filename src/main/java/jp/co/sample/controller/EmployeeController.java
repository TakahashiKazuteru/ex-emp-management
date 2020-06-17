package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		Employee employee = service.showDetail(Integer.parseInt(id));
		model.addAttribute("employee",employee);
		
		return "/employee/detail";
	}

}
