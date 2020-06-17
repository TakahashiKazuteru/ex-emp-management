package jp.co.sample.form;

public class InsertAdministratorForm {
	/** 保持者の名前を保持する */
	private String name;
	/** 保持者のメールアドレスを保持する */
	private String mailAddress;
	/** 保持者のパスワードを保持する */
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
