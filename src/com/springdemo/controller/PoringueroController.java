package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poringuero")
public class PoringueroController {
	
	@RequestMapping("/mostrarform")
	public String mostrarForm() {
		return "poringuero-form";
	}

}
