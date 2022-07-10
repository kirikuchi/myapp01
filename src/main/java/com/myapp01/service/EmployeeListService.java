package com.myapp01.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp01.entity.EmployeeEntity;
import com.myapp01.form.EmployeeListForm;
import com.myapp01.mapper.EmployeeMapper;

/**
 * 社員情報検索サービス
 */
@Service
@Transactional
public class EmployeeListService {
	// 社員情報マッパー
	@Autowired
	EmployeeMapper employeeMapper;
	
	/**
	 * 社員情報検索
	 * @param employeeListForm 社員情報検索フォーム
	 */
	public void search (EmployeeListForm employeeListForm) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeListForm, entity);
		List<EmployeeEntity>result = employeeMapper.search(entity);
		employeeListForm.setEmployeeList(result);
	}
}
