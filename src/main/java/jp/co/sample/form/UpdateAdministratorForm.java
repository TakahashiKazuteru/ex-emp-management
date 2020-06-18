package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 管理者情報更新時に使用するフォーム.
 * 
 * @author kazuteru.takahashi
 *
 */
public class UpdateAdministratorForm {
	/** 名前 */
	@NotBlank(message = "空では更新できません")
	private String name;
	/** メールアドレス */
	@NotBlank(message = "空では更新できません")
	@Email(message = "メールアドレスを入力してください")
	private String mailAddress;
	/** パスワード */
	@NotBlank(message = "空では更新できません")
	private String password;

	@Override
	public String toString() {
		return "UpdateAdministratorForm [name=" + name + ", email=" + mailAddress + ", password=" + password + "]";
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
