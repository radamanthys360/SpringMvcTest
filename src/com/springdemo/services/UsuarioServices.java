package com.springdemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		Page<Usuario> paginado = getPaginado(pageable);
		for (Usuario var : paginado) {
			String versionesTexto = "";
			TaringueroDto taringueroDtoT = new TaringueroDto();
			taringueroDtoT.setId(var.getCodigo());
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
			List<Integer> ListaPaginador = new ArrayList<Integer>();
			for (int i = 1; i <= paginado.getTotalPages(); i++) {
				ListaPaginador.add(i);
			}
			taringueroDtoT.setDatosPaginador(ListaPaginador);
			usuarios.add(taringueroDtoT);
		}
		return usuarios;
	}
	
	public long getCount() {
		return usuarioRepository.count();
	}
	
	@Transactional
	public List<TaringueroDto> busquedaTotal(String texto,Pageable pageable) {
			List<TaringueroDto> usuarios = new ArrayList<TaringueroDto>();
			Page<Usuario> busquedaTotal = usuarioRepository.busquedaTotal(texto,pageable);
			for (Usuario var : busquedaTotal) {
				String versionesTexto = "";
				TaringueroDto taringueroDtoT = new TaringueroDto();
				taringueroDtoT.setId(var.getCodigo());
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
				List<Integer> ListaPaginador = new ArrayList<Integer>();
				for (int i = 1; i <= busquedaTotal.getTotalPages(); i++) {
					ListaPaginador.add(i);
				}
				taringueroDtoT.setDatosPaginador(ListaPaginador);
				usuarios.add(taringueroDtoT);
			}
			return usuarios; 
	}
	
	@Transactional
	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}
	
	@Transactional
	public TaringueroDto buscarPorIdDto(Long id) {
		Optional<Usuario> entidad = buscarPorId(id);
		if(entidad.isPresent()) {
			int contador = 0;
			Usuario var = entidad.get();
			String versionesTexto = "";
			TaringueroDto taringueroDtoT = new TaringueroDto();
			taringueroDtoT.setId(var.getCodigo());
			taringueroDtoT.setNombreUsuario(var.getNombreUsuario());
			taringueroDtoT.setEdad(var.getEdad());
			taringueroDtoT.setGenero(var.getGenero().getTipo());
			taringueroDtoT.setSigoVirgo(var.getSigoVirgo());
			taringueroDtoT.setFacha(var.getFacha());
			Set<Version> versiones = var.getVersiones();
			String[] versionesDto = new String[versiones.size()];;
			for (Version version : versiones) {
				if(versiones.size() > 1) {
					versionesTexto += version.getCodigo()+",";
					versionesDto[contador] = version.getCodigo();
					contador++;
				}else {
					versionesTexto += version.getCodigo();
					versionesDto[contador] = version.getCodigo();
					contador++;
				}
			}
			taringueroDtoT.setVersiones(versionesDto);
			taringueroDtoT.setVersionestexto(versionesTexto);
			return taringueroDtoT;
		}else {
			return null;
		}
			
	}
}
