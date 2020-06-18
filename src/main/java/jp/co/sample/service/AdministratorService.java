package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報を操作するサービスクラス.
 * 
 * @author kazuteru.takahashi
 *
 */
@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository repository;
	
	/**
	 * 新規管理者情報登録.
	 * 
	 * @param 管理者情報
	 */
	public void insert(Administrator administrator) {
		repository.insert(administrator);
	}
	
	/**
	 * メールアドレスとパスワードから管理者であるかを検索.
	 * 
	 * @param mailAddress メールアドレス
	 * @param password パスワード
	 * @return 管理者情報
	 */
	public Administrator findByMailaddressAndPassword(String mailAddress,String password) {
		return repository.findByMailaddressAndPassword(mailAddress, password);
	}
	/**
	 * IDから管理者情報を検索.
	 * 
	 * @param id ID
	 * @return 管理者情報
	 */
	public Administrator load(Integer id) {
		return repository.load(id);
	}
	
	/**
	 * 管理者情報を更新.
	 * 
	 * @param administrator 管理者情報
	 */
	public void update(Administrator administrator) {
		repository.update(administrator);
	}
}
