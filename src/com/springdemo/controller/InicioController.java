package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	
	@RequestMapping("/")
	public String mostrarInicio() {
		return "menu-inicio";
	}

}
