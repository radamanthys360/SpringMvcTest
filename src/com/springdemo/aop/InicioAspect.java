package com.springdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
//	@AfterThrowing(
//			pointcut="execution(* com.springdemo.controller.InicioController.login (..))",
//			throwing="theExc")
//	public void afterThrowingLogin(JoinPoint theJoinPoint, Throwable theExc) {		
//		// obtenemos el nombre del metodo a ejecutar
//		String method = theJoinPoint.getSignature().toShortString();
//		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
//		//  exception
//		System.out.println("\n=====>>> The exception is: " + theExc);
//	}
	
	//si da error o no usamos esto luego de la ejecucion del metodo.
//	@After("execution(* com.springdemo.controller.InicioController.login (..))")
//	public void afterLogin(JoinPoint theJoinPoint) {		
//		// obtenemos el nombre del metodo a ejecutar
//		String method = theJoinPoint.getSignature().toShortString();
//		System.out.println("\n=====>>> Executing @After on method: " + method);
//	}
	
	
	//esto lo usamos para controlar el antes y despues de le ejecucion del metodo Ejemplo 1
//	@Around("execution(* com.springdemo.controller.InicioController.login (..))")
//	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		
//		String method = proceedingJoinPoint.getSignature().toShortString();
//		System.out.println("\n=====>>> Executing @Around : " + method);
//		
//		// ejecutando el metodo
//		Object result = proceedingJoinPoint.proceed();
//		
//		System.out.println("\n=====> resultado: " + result);
//		
//		return result;
//	}
	
	//esto lo usamos para controlar el antes y despues de le ejecucion del metodo ejemplo 2
//	@Around("execution(* com.springdemo.controller.InicioController.login (..))")
//	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		
//		String method = proceedingJoinPoint.getSignature().toShortString();
//		System.out.println("\n=====>>> Executing @Around : " + method);
//		
//		// ejecutando el metodo
//		Object result = null;
//		try {
//			result = proceedingJoinPoint.proceed();
//		} catch (Throwable e) {
//			System.out.println("grave ha sucedido un error " + e.getMessage());
//			result = "inicio";
//		}
//		
//		System.out.println("\n=====> resultado: " + result);
//		
//		return result;
//	}
	
	
	//esto lo usamos para controlar el antes y despues de le ejecucion del metodo ejemplo 3
//	@Around("execution(* com.springdemo.controller.InicioController.login (..))")
//	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		
//		String method = proceedingJoinPoint.getSignature().toShortString();
//		System.out.println("\n=====>>> Executing @Around : " + method);
//		
//		// ejecutando el metodo
//		Object result = null;
//		try {
//			result = proceedingJoinPoint.proceed();
//		} catch (Throwable e) {
//			System.out.println("grave ha sucedido un error " + e.getMessage());
//			throw e;
//		}
//		
//		System.out.println("\n=====> resultado: " + result);
//		
//		return result;
//	}
	
	
}
