package com.flightbackend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.flightbackend.api.service.MyUserDetailService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailService myUserDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDBAuth());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/login").authenticated()
			.antMatchers("/user/details").authenticated()
			.antMatchers("/customer/getAll").hasAuthority("ADMIN")
			.antMatchers("/vendor/getAll").hasAuthority("ADMIN")
			.antMatchers("/admin/approveOrrejectVendor/{id}").hasAuthority("ADMIN")
			.antMatchers("/customer/edit/{id}").hasAuthority("CUSTOMER")
			.antMatchers("/customer/bookFlight/{cid}/{fid}").hasAuthority("CUSTOMER")
			.antMatchers("/flight/add/{vid}").hasAuthority("VENDOR")
			.antMatchers("/flight/vendor/{vid}").hasAuthority("VENDOR")
			.antMatchers("/vendor/edit/{id}").hasAuthority("VENDOR")
			.antMatchers("/flight/getAll").hasAuthority("VENDOR")
			.antMatchers("/flight/edit/{id}").hasAuthority("VENDOR")
			.antMatchers("/flight/delete/{id}").hasAuthority("VENDOR")
			.anyRequest().permitAll()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public DaoAuthenticationProvider getDBAuth() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myUserDetailService);
		return dao;
	}
}
