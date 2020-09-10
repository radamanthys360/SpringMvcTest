package com.springdemo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springdemo.services.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

//Para cualquier solicitud entrante, esta  Filter clase se ejecuta. 
//Comprueba si la solicitud tiene un token JWT v�lido. Si tiene un token JWT v�lido, 
//establece la autenticaci�n en contexto para especificar que el usuario actual est� autenticado
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		if (requestTokenHeader != null ) {
			try {
				username = jwtTokenUtil.getUsernameFromToken(requestTokenHeader);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		}

		//una vez el tokent este autorizado..
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
			// si el token es v�lido, configure Spring Security para configurar manualmente la autenticaci�n
			if (jwtTokenUtil.validateToken(requestTokenHeader, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// Despu�s de configurar la autenticaci�n en el contexto, especificamos
				// que el usuario actual est� autenticado. Por lo tanto, pasa las configuraciones de seguridad de Spring con �xito.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}

}