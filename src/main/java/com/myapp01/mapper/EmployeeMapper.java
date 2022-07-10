package com.myapp01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.myapp01.entity.EmployeeEntity;

/**
 * 社員情報マッパー
 */
@Mapper
public interface EmployeeMapper {
	/**
	 * 社員情報検索
	 * @param entity 社員情報
	 * @return 社員情報
	 */
	List<EmployeeEntity> search(EmployeeEntity entity);
	
	/**
	 * 社員情報検索
	 * @param empId 社員ID
	 * @return 社員情報
	 */
	EmployeeEntity searchById(String empId);
	
	/**
	 * 社員情報更新
	 * @param entity 社員情報
	 */
	void updateById(EmployeeEntity entity);
}
