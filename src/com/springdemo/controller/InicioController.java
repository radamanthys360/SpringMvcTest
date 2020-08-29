package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	
	@RequestMapping("/")
	public String mostrarForm(Model modelo) {
		return "menu-inicio";
	}
	
	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";
	}	

}
