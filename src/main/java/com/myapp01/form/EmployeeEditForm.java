package com.myapp01.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * 社員情報更新フォーム
 */
public class EmployeeEditForm {
	// 社員ID
	private String empId;
	
	// 姓
	@NotEmpty(message = "{err.empId.empty}")
	@Length(max=5, message = "{err.lastName.length}")
	private String lastName;
	
	// 名
	@NotEmpty(message = "{err.lastName.empty}")
	@Length(max=5, message = "{err.firstName.length}")
	private String firstName;
	
	// 姓（カナ）
	@NotEmpty(message = "{err.lastNameKana.empty}")
	@Length(max=10, message = "{err.lastNameKana.length}")
	private String lastNameKana;
	
	// 名（カナ）
	@NotEmpty(message = "{err.firstNameKana.empty}")
	@Length(max=10, message = "{err.firstNameKana.length}")
	private String firstNameKana;
	
	// 性別
	@NotEmpty(message = "{err.gender.empty}")
	private String gender;
	
	// 生年月日
	@NotEmpty(message = "{err.birthday.empty}")
	private String birthday;
	
	// 血液型
	@NotEmpty(message = "{err.bloodType.empty}")
	private String bloodType;
	
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
}
