package jp.co.sample.form;

import javax.validation.constraints.NotBlank;
/**
 * 
 * @author kazuteru.takahashi
 *
 */
public class InsertAdministratorForm {
	/** 保持者の名前を保持する */
	@NotBlank(message = "氏名を入力してください")
	private String name;
	/** 保持者のメールアドレスを保持する */
	@NotBlank(message = "メールアドレスを入力してください")
	private String mailAddress;
	/** 保持者のパスワードを保持する */
	@NotBlank(message = "パスワードを入力してください")
	private String password;

	@Override
	public String toString() {
		return "AdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
