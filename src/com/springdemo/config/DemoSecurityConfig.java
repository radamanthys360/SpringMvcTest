package com.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// solo para testing
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("facha").password("test123").roles("VIRGO","TARINGUERO"))
			.withUser(users.username("toto32").password("test123").roles("VIRGO","PORINGUERO"))
			.withUser(users.username("radamanthys").password("test123").roles("VIRGO","ADMIN","TARINGUERO","PORINGUERO"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasRole("VIRGO")
			.antMatchers("/taringuero/**").hasRole("TARINGUERO")
			.antMatchers("/poringuero/**").hasRole("PORINGUERO")
			.and()
			.formLogin()
				.loginPage("/inicio")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout().permitAll();
	}
	
}
