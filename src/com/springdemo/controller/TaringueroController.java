package com.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.db.entity.Genero;
import com.springdemo.dto.TaringueroDto;
import com.springdemo.services.GeneroServices;

@Controller
@RequestMapping("/taringuero")
public class TaringueroController {
	
	@Autowired
	GeneroServices generoServices;
	
	//metodo para quitar espacios en blanco
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/mostrarform")
	public String mostrarform(Model modelo) {
		TaringueroDto taringueroDto = new TaringueroDto();
		modelo.addAttribute("taringueroDto",taringueroDto);
		return "taringuero-form";
	}
	
	@RequestMapping("/procesarform")
	public String procesarform(@Valid @ModelAttribute("taringueroDto") TaringueroDto taringueroDto,
			                   BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "taringuero-form";
		}
		else {
			
			List<Genero> allGenero = generoServices.getAllGenero();
			for (Genero genero : allGenero) {
				System.out.println("generos "+genero.getTipo());
			}
			
			System.out.println("nombreUsuario "+taringueroDto.getNombreUsuario());
			System.out.println("edad "+taringueroDto.getEdad().toString());
			System.out.println("genero "+taringueroDto.getGenero());
			System.out.println("sigoVirgo "+taringueroDto.getSigoVirgo());
			System.out.println("facha "+taringueroDto.getFacha());
			for (String var : taringueroDto.getVersiones()) {
				System.out.println("versiones "+var);
			}
			return "taringuero-form";
		}
	
	}

}
