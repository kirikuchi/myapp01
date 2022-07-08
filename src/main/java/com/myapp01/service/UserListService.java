package com.myapp01.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp01.entity.PersonEntity;
import com.myapp01.mapper.PersonMapper;

@Service
@Transactional
public class UserListService {
	@Autowired
	PersonMapper personMapper;
	
	public String search () {
		
		Collection<PersonEntity> c1 = personMapper.findAll();
		for (PersonEntity entity : c1) {
			System.out.println("c1 ===> " + entity.getId() + ", " + entity.getAge() + ", " + entity.getName());
		}
		
		return "test";
	}
}
