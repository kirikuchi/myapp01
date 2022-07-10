package com.myapp01.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp01.entity.EmployeeEntity;
import com.myapp01.form.EmployeeEditForm;
import com.myapp01.mapper.EmployeeMapper;

/**
 * 社員情報更新サービス
 */
@Service
@Transactional
public class EmployeeEditService {
	// 社員情報マッパー
	@Autowired
	EmployeeMapper employeeMapper;
	
	/**
	 * 社員情報検索
	 * @param empId 社員ID
	 * @param employeeEditForm 社員情報更新フォーム
	 */
	public void searchById (String empId, EmployeeEditForm employeeEditForm) {
		EmployeeEntity entity = employeeMapper.searchById(empId);
		BeanUtils.copyProperties(entity, employeeEditForm);
	}
	
	/**
	 * 社員情報更新
	 * @param employeeEditForm 社員情報更新フォーム
	 */
	public void update (EmployeeEditForm employeeEditForm) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeEditForm, employeeEntity);
		try {
			employeeMapper.updateById(employeeEntity);
		} catch (Exception e) {
			// 更新失敗時はスルーして一覧画面に戻る
		}
	}
}
