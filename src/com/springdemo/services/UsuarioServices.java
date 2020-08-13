package com.springdemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.db.entity.Usuario;
import com.springdemo.db.entity.Version;
import com.springdemo.db.repository.UsuarioRepository;
import com.springdemo.dto.TaringueroDto;

@Service
public class UsuarioServices {
	
	@Autowired
	private UsuarioRepository<Usuario> usuarioRepository;
	
	@Transactional
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Page<Usuario> getPaginado(Pageable pageable) {
		return usuarioRepository.findAll(pageable);
	}
	
	@Transactional
	public List<TaringueroDto> retornarSetUsuarios(Pageable pageable){
		List<TaringueroDto> usuarios = new ArrayList<TaringueroDto>();
		for (Usuario var : getPaginado(pageable)) {
			String versionesTexto = "";
			TaringueroDto taringueroDtoT = new TaringueroDto();
			taringueroDtoT.setNombreUsuario(var.getNombreUsuario());
			taringueroDtoT.setEdad(var.getEdad());
			taringueroDtoT.setGenero(var.getGenero().getTipo());
			taringueroDtoT.setSigoVirgo(var.getSigoVirgo());
			taringueroDtoT.setFacha(var.getFacha());
			Set<Version> versiones = var.getVersiones();
			for (Version version : versiones) {
				if(versiones.size() > 1) {
					versionesTexto += version.getCodigo()+",";
				}else {
					versionesTexto += version.getCodigo();
				}
			}
			taringueroDtoT.setVersionestexto(versionesTexto);
			usuarios.add(taringueroDtoT);
		}
		return usuarios;
	}
	
	public long getCount() {
		return usuarioRepository.count();
	}

}
