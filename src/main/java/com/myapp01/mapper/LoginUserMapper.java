package com.myapp01.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myapp01.entity.LoginUserEntity;

@Mapper
public interface LoginUserMapper {
	LoginUserEntity findByUserId(String userId);
}
