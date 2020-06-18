package jp.co.sample.form;

public class SearchEmployeeForm {
	/** 名前曖昧検索用 */
	private String searchName;

	@Override
	public String toString() {
		return "SearchEmployeeForm [searchName=" + searchName + "]";
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

}
