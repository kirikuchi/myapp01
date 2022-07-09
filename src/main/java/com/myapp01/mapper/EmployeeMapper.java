package com.myapp01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.myapp01.entity.EmployeeEntity;

@Mapper
public interface EmployeeMapper {
	List<EmployeeEntity> search(EmployeeEntity entity);
	EmployeeEntity searchById(String empId);
	void updateById(EmployeeEntity entity);
}
