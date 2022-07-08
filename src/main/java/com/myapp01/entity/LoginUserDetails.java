package com.myapp01.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private final LoginUserEntity loginUserEntity;

	public LoginUserDetails(LoginUserEntity loginUserEntity) {
      this.loginUserEntity = loginUserEntity;
  }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return loginUserEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return loginUserEntity.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
