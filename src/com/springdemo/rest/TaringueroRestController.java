package com.springdemo.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.db.entity.Genero;
import com.springdemo.db.entity.Usuario;
import com.springdemo.db.entity.Version;
import com.springdemo.dto.TaringueroDto;
import com.springdemo.exception.NotFoundException;
import com.springdemo.services.GeneroServices;
import com.springdemo.services.UsuarioServices;
import com.springdemo.services.VersionServices;

@RestController
@RequestMapping("/api")
public class TaringueroRestController {
	
	@Autowired
	private UsuarioServices usuarioServices;
	@Autowired
	private VersionServices versionServices;
	@Autowired
	private GeneroServices generoServices;

	
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
	
	@PostMapping("/taringueros")
	public TaringueroDto saveUsuario(@RequestBody TaringueroDto taringueroDto) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(taringueroDto.getNombreUsuario());
	    usuario.setEdad(taringueroDto.getEdad());
	    Optional<Genero> genero2 = generoServices.getGenero(taringueroDto.getGenero());
	    if (genero2.isPresent()){
	    	usuario.setGenero(genero2.get());
	    }
	    else{
	    	throw new NotFoundException("Genero not found - " + taringueroDto.getGenero());
	    }
	    usuario.setSigoVirgo(taringueroDto.getSigoVirgo());
	    usuario.setFacha(taringueroDto.getFacha());
	    Set<Version> listaUsuVer = new  HashSet<Version>();
	    if(taringueroDto.getVersiones() != null ) {
			for (String var : taringueroDto.getVersiones()) {
				Optional<Version> version = versionServices.getVersion(var);
			    if (version.isPresent()){
				    listaUsuVer.add(version.get());
			    }
			    else{
			    	throw new NotFoundException("Version not found - " + var);
			    }
			}
	    }
		usuario.setVersiones(listaUsuVer);
		return usuarioServices.getUsuarioDtoFromEntity(usuarioServices.guardar(usuario));
	}
	
	@PutMapping("/taringueros")
	public TaringueroDto updateUsuario(@RequestBody TaringueroDto taringueroDto) throws Exception {
		Usuario usuario = null;
		if(taringueroDto.getId() != null) {
			Optional<Usuario> buscarPorId = usuarioServices.getUsuario(taringueroDto.getId());
			if(buscarPorId.isPresent()) {
			   usuario = buscarPorId.get();
			}else {
				throw new NotFoundException("Taringuero not found - " + taringueroDto.getId());
			}
		}
		usuario.setNombreUsuario(taringueroDto.getNombreUsuario());
	    usuario.setEdad(taringueroDto.getEdad());
	    Optional<Genero> genero2 = generoServices.getGenero(taringueroDto.getGenero());
	    if (genero2.isPresent()){
	    	usuario.setGenero(genero2.get());
	    }
	    else{
	    	throw new NotFoundException("Genero not found - " + taringueroDto.getGenero());
	    }
	    usuario.setSigoVirgo(taringueroDto.getSigoVirgo());
	    usuario.setFacha(taringueroDto.getFacha());
	    Set<Version> listaUsuVer = new  HashSet<Version>();
	    if(taringueroDto.getVersiones() != null ) {
			for (String var : taringueroDto.getVersiones()) {
				Optional<Version> version = versionServices.getVersion(var);
			    if (version.isPresent()){
				    listaUsuVer.add(version.get());
			    }
			    else{
			    	throw new NotFoundException("Version not found - " + var);
			    }
			}
	    }
		usuario.setVersiones(listaUsuVer);
		return usuarioServices.getUsuarioDtoFromEntity(usuarioServices.guardar(usuario));
	}
	
	@DeleteMapping("/taringueros/{id}")
	public String deleteUsuario(@PathVariable Long id) {
		TaringueroDto usuarioDto = usuarioServices.getUsuarioDto(id);
		if(usuarioDto != null) {
			usuarioServices.eliminar(id);
			return "OK";
		}else {
			throw new NotFoundException("Taringuero not found - " + id);
		}
	}

}
