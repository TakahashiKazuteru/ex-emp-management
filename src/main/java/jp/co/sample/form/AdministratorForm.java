package jp.co.sample.form;

public class AdministratorForm {
	/** 保持者IDを保持する */
	private String id;
	/** 保持者の名前を保持する */
	private String name;
	/** 保持者のメールアドレスを保持する */
	private String mailAddress;
	/** 保持者のパスワードを保持する */
	private String password;

	@Override
	public String toString() {
		return "AdministratorForm [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password="
				+ password + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
