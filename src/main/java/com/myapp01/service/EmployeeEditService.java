package com.myapp01.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp01.entity.EmployeeEntity;
import com.myapp01.form.EmployeeEditForm;
import com.myapp01.mapper.EmployeeMapper;

@Service
@Transactional
public class EmployeeEditService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void searchById (String empId, EmployeeEditForm employeeEditForm) {
		EmployeeEntity entity = employeeMapper.searchById(empId);
		BeanUtils.copyProperties(entity, employeeEditForm);
	}
	
	public void update (EmployeeEditForm employeeEditForm) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeEditForm, employeeEntity);
		employeeMapper.updateById(employeeEntity);
	}
}
