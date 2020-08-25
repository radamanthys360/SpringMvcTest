package com.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	//luego de un error en el metodo
	@AfterThrowing(
			pointcut="execution(* com.springdemo.controller.InicioController.login (..))",
			throwing="theExc")
	public void afterThrowingLogin(JoinPoint theJoinPoint, Throwable theExc) {		
		// obtenemos el nombre del metodo a ejecutar
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
		//  exception
		System.out.println("\n=====>>> The exception is: " + theExc);
	}
	
	//si da error o no usamos esto luego de la ejecucion del metodo.
	@After("execution(* com.springdemo.controller.InicioController.login (..))")
	public void afterLogin(JoinPoint theJoinPoint) {		
		// obtenemos el nombre del metodo a ejecutar
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After on method: " + method);
	}
	
}
