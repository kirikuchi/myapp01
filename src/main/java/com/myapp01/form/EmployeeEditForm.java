package com.myapp01.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class EmployeeEditForm {
	private String empId;
	
	@NotEmpty(message = "{err.empId.empty}")
	@Length(max=5, message = "{err.lastName.length}")
	private String lastName;
	
	@NotEmpty(message = "{err.lastName.empty}")
	@Length(max=5, message = "{err.fastName.length}")
	private String fastName;
	
	@NotEmpty(message = "{err.lastNameKana.empty}")
	@Length(max=10, message = "{err.lastNameKana.length}")
	private String lastNameKana;
	
	@NotEmpty(message = "{err.fastNameKana.empty}")
	@Length(max=10, message = "{err.fastNameKana.length}")
	private String fastNameKana;
	
	@NotEmpty(message = "{err.gender.empty}")
	private String gender;
	
	@NotEmpty(message = "{err.birthday.empty}")
	private String birthday;
	
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
	public String getFastName() {
		return fastName;
	}
	public void setFastName(String fastName) {
		this.fastName = fastName;
	}
	public String getLastNameKana() {
		return lastNameKana;
	}
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
	public String getFastNameKana() {
		return fastNameKana;
	}
	public void setFastNameKana(String fastNameKana) {
		this.fastNameKana = fastNameKana;
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
