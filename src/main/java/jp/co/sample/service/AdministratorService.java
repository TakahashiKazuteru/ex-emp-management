package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 
 * @author kazuteru.takahashi
 *
 */
@Service
@Transactional
public class AdministratorService {
	@Autowired
	private AdministratorRepository repository;
	
	public void insert(Administrator administrator) {
		repository.insert(administrator);
	}
	
	public Administrator findByMailaddressAndPassword(String mailAddress,String password) {
		return repository.findByMailaddressAndPassword(mailAddress, password);
	}
}
