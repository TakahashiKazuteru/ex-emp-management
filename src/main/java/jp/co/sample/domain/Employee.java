package jp.co.sample.domain;

import java.util.Date;

/**
 * 
 * @author kazuteru.takahashi
 *
 */
public class Employee {
	/** 社員IDを保持する */
	private Integer id;
	/** 社員の名前を保持する */
	private String name;
	/** 社員の画像ファイル名を保持する */
	private String image;
	/** 社員の性別情報を保持する */
	private String gender;
	/** 社員の入社日を保持する */
	private Date hireDate;
	/** 社員のメールアドレスを保持する */
	private String mailAddress;
	/** 社員の郵便番号を保持する */
	private String zipCode;
	/** 社員の住所を保持する */
	private String address;
	/** 社員の電話番号を保持する */
	private String telephone;
	/** 社員の給料を保持する */
	private Integer salary;
	/** 社員の特技を保持する */
	private String characteristics;
	/** 社員の扶養人数を保持する */
	private Integer dependentsCount;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hireDate="
				+ hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public Integer getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(Integer dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

}
