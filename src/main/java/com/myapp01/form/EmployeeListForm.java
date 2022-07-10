package com.myapp01.form;

import java.io.Serializable;
import java.util.List;
import com.myapp01.entity.EmployeeEntity;

/**
 * 社員情報検索フォーム
 */
public class EmployeeListForm implements Serializable {
	private static final long serialVersionUID = 1L;
	// 社員ID
	private String empId;
	// 姓
	private String lastName;
	// 名
	private String firstName;
	// 姓（カナ）
	private String lastNameKana;
	// 名（カナ）
	private String firstNameKana;
	// 性別
	private String gender;
	// 生年月日
	private String birthday;
	// 血液型
	private String bloodType;
	// 検索結果のスクロールバーの位置
	private String hdnScrollTop;
	// 社員情報の検索結果
	private List<EmployeeEntity>employeeList;

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNameKana() {
		return lastNameKana;
	}
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getHdnScrollTop() {
		return hdnScrollTop;
	}
	public void setHdnScrollTop(String hdnScrollTop) {
		this.hdnScrollTop = hdnScrollTop;
	}
	public List<EmployeeEntity> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeEntity> employeeList) {
		this.employeeList = employeeList;
	}
}
