package jp.co.sample.form;

import javax.validation.constraints.NotBlank;
/**
 * 
 * 管理者登録時に使用するフォーム.
 * 
 * @author kazuteru.takahashi
 *
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank(message = "氏名を入力してください")
	private String name;
	/** メールアドレス */
	@NotBlank(message = "メールアドレスを入力してください")
	private String mailAddress;
	/** パスワード */
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
