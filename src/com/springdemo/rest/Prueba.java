package com.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class Prueba {
	
	@GetMapping("/hola")
	public String holaMundo() {
		return "hola Mundo!";
	}

}
