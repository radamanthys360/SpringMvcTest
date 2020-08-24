package com.springdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InicioAspect {
	
	@Before("execution(public String login(..))")
	public void beforeLogin() {
		//System.out.println("\n=====>>> ejecutar @Before(antes) del metodo de login ");
	}

}
