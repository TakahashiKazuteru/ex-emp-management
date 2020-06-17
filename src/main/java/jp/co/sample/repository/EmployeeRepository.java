package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

@Repository
public class EmployeeRepository {
	private static final String TABLE_NAME = "employees";
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs,i) ->{
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setImage(rs.getString("image"));
		employee.setGender(rs.getString("gender"));
		employee.setHireDate(rs.getDate("hire_date"));
		employee.setMailAddress(rs.getString("mail_address"));
		employee.setTelephone(rs.getString("telephone"));
		employee.setSalary(rs.getInt("salary"));
		employee.setCharacteristics(rs.getString("characteristics"));
		employee.setDependentsCount(rs.getInt("dependents_count"));
		return employee;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Employee> findAll(){
		
		System.out.println("Debug:called findAll()");
		return null;
	}
	
	public Employee load(Integer id) {
		
		System.out.println("Debug:called load()");
		return null;
	}
	
	public void update(Employee employee) {
		
		System.out.println("Debug:called update()");
	}
	
}
