package jp.co.sample.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

/**
 * 社員の扶養人数を更新するときに使用するフォーム.
 * 
 * @author kazuteru.takahashi
 *
 */
public class UpdateEmployeeForm {
	/** ID */
	private String id;
	/** 扶養人数 */
	@NotBlank(message = "空で更新はできません")
	@Range(message = "数字を入力してください")
	private String dependentsCount;

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
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

}
