package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.dto.TaringueroDto;

@Controller
@RequestMapping("/taringuero")
public class TaringueroController {
	
	@RequestMapping("/mostrarform")
	public String mostrarform(Model modelo) {
		TaringueroDto taringueroDto = new TaringueroDto();
		modelo.addAttribute("taringueroDto",taringueroDto);
		return "taringuero-form";
	}
	
	@RequestMapping("/procesarform")
	public String procesarform(@ModelAttribute("taringueroDto") TaringueroDto taringueroDto) {
		System.out.println("nombreUsuario "+taringueroDto.getNombreUsuario());
		System.out.println("edad "+taringueroDto.getEdad().toString());
		System.out.println("genero "+taringueroDto.getGenero());
		System.out.println("sigoVirgo "+taringueroDto.getSigoVirgo());
		System.out.println("facha "+taringueroDto.getFacha());
		for (String var : taringueroDto.getVersiones()) {
			System.out.println("versiones "+var);
		}
		return  "taringuero-form";
	}

}
