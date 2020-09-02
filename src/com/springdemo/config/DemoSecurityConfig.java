package com.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.springdemo.services.PermisoRecursoServices;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PermisoRecursoServices permisoRecursoServices;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		HttpSecurity permisos = permisos(http);
		permisos.authorizeRequests()
			.and()
			.formLogin()
				.loginPage("/inicio")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/denegado");
	}
	
	private HttpSecurity permisos(HttpSecurity http) throws Exception {
		Object[][] findPermisoRecurso = permisoRecursoServices.findPermisoRecurso();
    	for (Object[] permisosDto : findPermisoRecurso) {
    		http.authorizeRequests().antMatchers(permisosDto[0].toString()).
    		hasAnyRole(permisosDto[1].toString());
		}
		return http;
	}
	
}
