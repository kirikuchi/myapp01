package com.myapp01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myapp01.entity.LoginUserDetails;
import com.myapp01.entity.LoginUserEntity;
import com.myapp01.mapper.LoginUserMapper;

/**
 * ログインユーザサービス
 */
@Service
public class LoginUserService implements UserDetailsService {

	// ログインユーザマッパー
	@Autowired
	private LoginUserMapper loginUserMapper;

	@Autowired
	public LoginUserService(LoginUserMapper loginUserMapper) {
		this.loginUserMapper = loginUserMapper;
	}

	/**
	 * ログインユーザ検索
	 */
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		LoginUserEntity loginUserEntity = loginUserMapper.findByUserId(userId);
		if (loginUserEntity == null) {
			throw new UsernameNotFoundException(userId + "が存在しません");
		}
		return new LoginUserDetails(loginUserEntity);
	}
}