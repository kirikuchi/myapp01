package com.myapp01.form;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.ObjectError;

import lombok.Data;

@Data
public class UserForm {
	@NotEmpty(message = "{err.name}")
    private String name;
	
	@NotEmpty(message = "{err.email}")
    private String email;
	
    @NotNull(message = "{err.age}")
    @Max(200)
    private BigDecimal age;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getAge() {
		return age;
	}
	public void setAge(BigDecimal age) {
		this.age = age;
	}
}
