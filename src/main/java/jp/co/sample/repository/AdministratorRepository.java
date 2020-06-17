package jp.co.sample.repository;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {
	private static final String TABLE_NAME = "administrators";
	private static final RowMapper<Administrator> ADMIN_ROW_MAPPER = (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mail_address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		String sql = "INSERT INTO " + TABLE_NAME + "(name,mail_address,password) VALUES(:name,:mail_address,password);";
		template.update(sql, param);
		System.out.println("Debug:called insert()!");
	}

	public Administrator findByMailaddressAndPassword(String mailAddress, String password) {
		String sql = "SELECT id FROM " + TABLE_NAME
				+ " WHERE (mail_address = :mailAddress) AND (password = :password);";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress)
																.addValue("password",password);
		try {
			return template.queryForObject(sql, param, ADMIN_ROW_MAPPER);
		}catch (Exception e) {
			return null;
		}finally {
			System.out.println("Debug:called findByMailaddressAndPassword()!");
		}
	}
}
