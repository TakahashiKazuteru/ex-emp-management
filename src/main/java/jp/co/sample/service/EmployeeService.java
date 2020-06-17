package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 社員情報を操作するサービス.
 * 
 * @author kazuteru.takahashi
 *
 */
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	/**
	 * 社員情報全件検索.
	 * 
	 * @return 社員情報全件(入社日降順)
	 */
	public List<Employee> showList(){
		return repository.findAll();
	}
	
	/**
	 * IDから社員情報を検索.
	 * 
	 * @param id ID
	 * @return 社員情報(0件ならばnullを返す)
	 */
	public Employee showDetail(Integer id) {
		return repository.load(id);
	}

}
