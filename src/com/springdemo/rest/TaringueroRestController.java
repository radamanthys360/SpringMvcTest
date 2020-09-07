package com.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.dto.TaringueroDto;
import com.springdemo.exception.NotFoundException;
import com.springdemo.services.UsuarioServices;

@RestController
@RequestMapping("/api")
public class TaringueroRestController {
	
	@Autowired
	private UsuarioServices usuarioServices;
	
	@GetMapping("/taringueros/{pagina}/{cantidad}")
	public List<TaringueroDto> getAllUsuarios(@PathVariable Integer pagina, @PathVariable Integer cantidad) {
		Pageable pageable = PageRequest.of(pagina, cantidad);
		return usuarioServices.getAllUsuarios(pageable);
	}
	
	@GetMapping("/taringueros/{id}")
	public TaringueroDto getUsuario(@PathVariable Long id) {
		TaringueroDto usuarioDto = usuarioServices.getUsuarioDto(id);
		if(usuarioDto != null) {
			return usuarioDto;
		}else {
			throw new NotFoundException("Taringuero not found - " + id);
		}
	}

}
