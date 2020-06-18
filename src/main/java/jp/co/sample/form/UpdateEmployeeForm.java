package jp.co.sample.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 社員の扶養人数を更新するときに使用するフォーム.
 * 
 * @author kazuteru.takahashi
 *
 */
public class UpdateEmployeeForm {
	/** ID */
	private String id;
	/** 名前 */
	@NotBlank(message = "空では更新できません")
	private String name;
	/** 性別 */
	@NotBlank(message = "空では更新できません")
	@Pattern(regexp = "^[男女]性$", message = "男性 or 女性で記述してください")
	private String gender;
	/** 入社日 */
	@NotNull(message = "空では更新できません")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	/** メールアドレス */
	@NotBlank(message = "空では更新できません")
	@Email(message = "メールアドレスを入力してください")
	private String mailAddress;
	/** 郵便番号 */
	@NotBlank(message = "空では更新できません")
	@Pattern(regexp = "^[0-9]{3}\\-[0-9]{4}$", message = "住所を入力してください")
	private String zipCode;
	/** 住所 */
	@NotBlank(message = "空では更新できません")
	private String address;
	/** 電話番号 */
	@NotBlank(message = "空では更新できません")
	@Pattern(regexp = "^0\\d{1,4}-\\d{1,4}-\\d{4}$", message = "電話番号を入力してください")
	private String telephone;
	/** 給料 */
	@NotBlank(message = "空では更新できません")
	private String salary;
	/** 特技 */
	@NotBlank(message = "空では更新できません")
	private String characteristics;
	/** 扶養人数 */
	@NotBlank(message = "空で更新はできません")
	@Range(message = "数字を入力してください")
	private String dependentsCount;

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", name=" + name + ", gender=" + gender + ", hireDate=" + hireDate
				+ ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address=" + address + ", telephone="
				+ telephone + ", salary=" + salary + ", characteristics=" + characteristics + ", dependentsCount="
				+ dependentsCount + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

}
