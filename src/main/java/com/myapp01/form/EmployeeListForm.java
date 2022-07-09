package com.myapp01.form;

import java.io.Serializable;
import java.util.List;
import com.myapp01.entity.EmployeeEntity;

public class EmployeeListForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private String empId;
	private String lastName;
	private String fastName;
	private String lastNameKana;
	private String fastNameKana;
	private String gender;
	private String birthday;
	private String bloodType;
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
	public List<EmployeeEntity> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeEntity> employeeList) {
		this.employeeList = employeeList;
	}
}
