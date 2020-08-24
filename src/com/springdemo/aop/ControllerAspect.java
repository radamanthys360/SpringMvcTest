package com.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
	
	//reutilizando aspectos
	@Pointcut("execution(* com.springdemo.controller.TaringueroController.busquedaTabla (..))")
	private void busquedaTabla() {}
	
//	//para todos lo metodos que se llamen mostrarForm incluyendo diferentes parametros
//	@Before("execution(* com.springdemo.controller.*.mostrarForm (..) )")
//	public void beforeMostrarForm() {
//		System.out.println("\n=====>>> ejecutar @Before(antes) del metodo de mostrarForm ");
//	}
//	
//	//para un metodo en especifico de una clase especifica
//	@Before("execution(* com.springdemo.controller.TaringueroController.mostrarForm (..) )")
//	public void beforeMostrarFormTaringuero() {
//		System.out.println("\n=====>>> ejecutar @Before(antes) "
//				+ "del metodo de mostrarForm Taringuero Controller ");
//	}
//	
//	//reutilizando aspectos
//	@Before("busquedaTabla()")
//	public void beforeBusquedaTabla1() {		
//		System.out.println("\n=====>>> Executing @Before busquedaTabla forma 1");		
//	}
//	
//	//reutilizando aspectos
//	@Before("busquedaTabla()")
//	public void beforeBusquedaTabla2() {		
//		System.out.println("\n=====>>> Executing @Before busquedaTabla forma 2");		
//	}

}
