package com.myapp01.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myapp01.entity.LoginUserEntity;

/**
 * ログインユーザマッパー
 */
@Mapper
public interface LoginUserMapper {
	/**
	 * ユーザ検索
	 * @param userId ユーザID
	 * @return ログイン情報
	 */
	LoginUserEntity findByUserId(String userId);
}
