package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;


/**
 * 
 * employeesテーブルを操作するためのリポジトリ.
 * 
 * @author kazuteru.takahashi
 *
 */
@Repository
public class EmployeeRepository {
	private static final String TABLE_NAME = "employees";
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs, i) -> {
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

	/**
	 * 全権検索をする.
	 * 
	 * @return 従業員一覧
	 */
	public List<Employee> findAll() {
		String sql = "SELECT id,name,image,gender,hire_date,mail_address,telephone,salary,characteristics,dependents_count "
				+ "FROM " + TABLE_NAME + " ORDER BY hire_date DESC;";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		System.out.println("Debug:called findAll()");
		return employeeList;
	}

	/**
	 * 指定されたIDから社員情報を取得します.
	 * 
	 * @param id ID
	 * @return 従業員情報(0件であればnullを返す)
	 */
	public Employee load(Integer id) {
		String sql = "SELECT id,name,image,gender,hire_date,mail_address,telephone,salary,characteristics,dependents_count "
				+ "FROM "+TABLE_NAME+" WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		try {
			return template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		}catch (Exception e) {
			return null;
		}finally {
			System.out.println("Debug:called load()");	
		}
	}

	/**
	 * ID以外の社員情報を更新.
	 * 
	 * @param 更新後の社員情報
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		String sql = "UPDATE "+TABLE_NAME+" SET name = :name,image = :image,gender = :gender,hire_date = :hireDate,mail_address = :mailAddress,"
				+ "telephone = :telephone,salary = :salary,characteristics = :characteristics,dependents_count = :dependentsCount"
				+ "WHERE id = :id;";
		template.update(sql, param);
		System.out.println("Debug:called update()");
	}

}
