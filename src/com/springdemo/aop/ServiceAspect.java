package com.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
	
	//para metodo de obtener un usuario
	@Pointcut("execution(* com.springdemo.services.UsuarioServices.getUsuario (..) )")
	private void getUsuario() {}
	
	//cuando se guarda un usuario
	@Pointcut("execution(* com.springdemo.services.UsuarioServices.guardar (..) )")
	private void guardar() {}
	
	//exactamente cuando se modificar un usuario existente
	@Pointcut("(getUsuario()) & (guardar())")
	private void modificarUsuario() {}
	
//	//para todos los metodos de la clase que comienzen con get
//	@Before("execution(* com.springdemo.services.UsuarioServices.get* (..) )")
//	public void beforeGetsUsuarioServices() {
//		System.out.println("\n=====>>> ejecutar @Before(antes) "
//				+ "de todos los metodos que comienzen con get en Usuario Services ");
//	}
//	
//	//para todos los metodos de un paquete especificado
//	@Before("execution(* com.springdemo.services.*.* (..) )")
//	public void beforePaqueteServices() {
//		System.out.println("\n=====>>> ejecutar @Before(antes) "
//				+ "de todos los metodos del paquete de servicios ");
//	}
//	
//	@Before("modificarUsuario()")
//	public void modificarUsuarioAspect() {
//		System.out.println("\n=====>>> se modifico un usuario");		
//	}
	
}
