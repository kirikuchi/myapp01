package com.myapp01.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.myapp01.entity.PersonEntity;

@Mapper
public interface PersonMapper {
	Collection<PersonEntity> findAll();

	Collection<PersonEntity> findById(Integer id);

	void create(PersonEntity personEntity);

	void deleteById(Integer id);

	void update(PersonEntity personEntity);

	List<Map<String, Object>> dynamic(String sql);
}
