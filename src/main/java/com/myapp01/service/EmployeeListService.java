package com.myapp01.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp01.entity.EmployeeEntity;
import com.myapp01.form.EmployeeListForm;
import com.myapp01.mapper.EmployeeMapper;

@Service
@Transactional
public class EmployeeListService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	public void search (EmployeeListForm employeeListForm) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeListForm, entity);
		List<EmployeeEntity>result = employeeMapper.search(entity);
		employeeListForm.setEmployeeList(result);
	}
}
