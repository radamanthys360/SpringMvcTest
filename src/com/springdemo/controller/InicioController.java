package com.springdemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dto.LoginDto;

@Controller
public class InicioController {
	
	@RequestMapping("/")
	public String mostrarForm(Model modelo) {
		LoginDto login = new LoginDto();
		modelo.addAttribute("loginDto",login);
		return "inicio";
	}
	
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("loginDto") LoginDto loginDto,
			                   BindingResult theBindingResult,Model modelo) throws Exception {
		if (theBindingResult.hasErrors()) {
			return "inicio";
		}
		else {
			//simulando login
			if(loginDto.getUsuario().contentEquals("admin") &&
			   loginDto.getClave().contentEquals("admin")	) {
				System.out.println("login Correcto");
				return "menu-inicio";
			}else {
				LoginDto login = new LoginDto();
				System.out.println("login Incorrecto");
				modelo.addAttribute("loginDto",login);
				modelo.addAttribute("error","S");
				modelo.addAttribute("mensaje","Usuario y clave no existen");
				throw new Exception("Error login credenciales de fbi ");//prueba para generar error.
				//return "inicio";
			}
		}
	}
	
	
	

}
