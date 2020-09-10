package com.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//seguridad para proyecto spring Rest.
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configurar AuthenticationManager 
		// usamos las credenciales autorizadas
		// Usamos BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// no necesitamos este tipo de comunicacion
		httpSecurity.csrf().disable()
				// solamente acceden todos al rest de autenticacion
				.authorizeRequests().antMatchers("/authenticate").permitAll().
				// las demas necesitan autenticacion
				anyRequest().authenticated().and().
				// nos aseguramos de usar un stateless session
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// añadimos el filtro para cada peticion
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}


// seguridad para proyecto spring mvc.

//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import com.springdemo.services.PermisoRecursoServices;
//
//@Configuration
//@EnableWebSecurity
//public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	private PermisoRecursoServices permisoRecursoServices;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource);
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		HttpSecurity permisos = permisos(http);
//		permisos.authorizeRequests()
//			.and()
//			.formLogin()
//				.loginPage("/inicio")
//				.loginProcessingUrl("/authenticateTheUser")
//				.permitAll()
//				.and()
//				.logout().permitAll()
//				.and()
//				.exceptionHandling().accessDeniedPage("/denegado");
//		http.csrf().disable(); // temporal solo para test rest sin seguridad
//	}
//	
//	private HttpSecurity permisos(HttpSecurity http) throws Exception {
//		Object[][] findPermisoRecurso = permisoRecursoServices.findPermisoRecurso();
//    	for (Object[] permisosDto : findPermisoRecurso) {
//    		http.authorizeRequests().antMatchers(permisosDto[0].toString()).
//    		hasAnyRole(permisosDto[1].toString());
//		}
//		return http;
//	}
//	
//}
