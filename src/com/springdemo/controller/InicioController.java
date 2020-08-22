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
	public String mostrarInicio(Model modelo) {
		LoginDto login = new LoginDto();
		modelo.addAttribute("loginDto",login);
		return "inicio";
		//return "menu-inicio";
	}
	
	
	@RequestMapping("/login")
	public String procesarform(@Valid @ModelAttribute("loginDto") LoginDto loginDto,
			                   BindingResult theBindingResult,Model modelo) {
		if (theBindingResult.hasErrors()) {
			return "inicio";
		}
		else {
			//simulando login
			if(loginDto.getUsuario().contentEquals("admin") &&
			   loginDto.getClave().contentEquals("admin")	) {
				return "menu-inicio";
			}else {
				LoginDto login = new LoginDto();
				modelo.addAttribute("loginDto",login);
				modelo.addAttribute("error","S");
				modelo.addAttribute("mensaje","Usuario y clave no existen");
				return "inicio";
			}
		}
	}
	
	
	

}
