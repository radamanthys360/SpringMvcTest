package com.springdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.db.entity.Usuario;
import com.springdemo.db.repository.UsuarioRepository;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository<Usuario> generoRepository;
	
	@Transactional
	public Usuario guardar(Usuario usuario) {
		return generoRepository.save(usuario);
	}

}
