package com.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.springdemo.dto.LoginDto;

@Aspect
@Component
public class InicioAspect {
	
//	@Before("execution(public String login(..))")
//	public void beforeLogin() {
//		//System.out.println("\n=====>>> ejecutar @Before(antes) del metodo de login ");
//	}
	
//	@Before("execution(* com.springdemo.controller.InicioController.login (..) )")
//	public void beforeLogin(JoinPoint joinPoint) {
//		System.out.println("\n=====>>> ejecutar @Before(antes) del metodo de login ");
//		
//		MethodSignature definicion = (MethodSignature) joinPoint.getSignature();
//		
//		System.out.println("Metodo: " + definicion);
//		
//		// obtener parametros
//		Object[] args = joinPoint.getArgs();
//		
//		//recorriendo parametros
//		for (Object tempArg : args) {
//			System.out.println(tempArg);
//			
//			if (tempArg instanceof LoginDto) {
//				
//				// casteo y mostrando datos
//				LoginDto loginDto = (LoginDto) tempArg;
//				
//				System.out.println("Usuario: " + loginDto.getUsuario());
//				System.out.println("Clave: " + loginDto.getClave());								
//
//			}
//		}
//	}

}
