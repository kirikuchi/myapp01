package com.myapp01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.myapp01.service.LoginUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private LoginUserService loginUserService;

	@Autowired
	public WebSecurityConfig(LoginUserService loginUserService) {
		this.loginUserService = loginUserService;
	}

	// URLパス毎に制御
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/js/**", "/css/**", "/login", "/eroor").permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").loginProcessingUrl("/signin").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/list/init", true).failureForwardUrl("/eroor").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
				.logoutSuccessUrl("/login")
				.permitAll();

		//http.csrf().disable();
		http.csrf().ignoringAntMatchers("/login").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

	// ユーザ情報の取得
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginUserService).passwordEncoder(passwordEncoder());
	}

	// パスワードハッシュ化する
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}
}
