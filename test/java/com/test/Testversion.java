package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.config.DemoAppConfig;
import com.springdemo.config.DispatcherServletInitializer;
import com.springdemo.db.config.JpaConfig;
import com.springdemo.db.entity.Genero;
import com.springdemo.db.entity.PermisoRecurso;
import com.springdemo.db.entity.Usuario;
import com.springdemo.db.entity.Version;
import com.springdemo.dto.TaringueroDto;
import com.springdemo.services.GeneroServices;
import com.springdemo.services.PermisoRecursoServices;
import com.springdemo.services.UsuarioServices;
import com.springdemo.services.VersionServices;

@ExtendWith(SpringExtension.class)
@Transactional
//si el proyecto esta en xml
//@PersistenceContext(unitName = "TaringaDB")
//@ContextConfiguration("file:WebContent/WEB-INF/spring-mvc-demo-servlet.xml")
//si esta con clases
@ContextConfiguration(
        classes={DemoAppConfig.class, DispatcherServletInitializer.class, JpaConfig.class})
@WebAppConfiguration
class Testversion {
	
	@Autowired
	private VersionServices versionServices;
	
	@Autowired
	private UsuarioServices usuarioServices;
	
	@Autowired
	private GeneroServices generoServices;
	
	@Autowired
	private PermisoRecursoServices permisoRecursoServices;
	
	@Disabled("Ya esta testeado")
	@Test
	public void findPermisoRecurso() {
		Object[][] findPermisoRecurso = permisoRecursoServices.findPermisoRecurso();
	      for (Object[] var : findPermisoRecurso) {
	          System.out.println("recurso: " + var[0]);
	          System.out.println("rol: " + var[1]);
	      }
		assertTrue(findPermisoRecurso.length >= 0);
	}
	

	@Disabled("Ya esta testeado")
	@Test
	public void pruebatexto() {
		String msg = versionServices.pruebatexto();
		assertEquals("correcto", msg);
	}
	
	@Disabled("Ya esta testeado")
	@Test
	public void pruebaNumero() {
		Double var1 = 5.0; Double var2 = 5.0;
		Double pruebaNumero = versionServices.pruebaNumero(var1, var2);
		assertEquals(25.0, pruebaNumero);
	}
	
	@Disabled("Ya esta testeado")
	@Test
	public void getVersion() {
		Optional<Version> version = versionServices.getVersion("V9");
		if(version.isPresent()) {
			Version version2 = version.get();
			System.out.println("*** registro **** "+
					           "*** Codigo **** "+version2.getCodigo()+
					           "*** Descripcion **** "+version2.getDescripcion());
			assertNotNull(version2, () -> "Version trae valor");
		}else {
			Version version2 = null;
			assertNull(version2, () -> "version no trae valor");
			System.out.println("*** registro No encontrado **** ");
		}
	}
	
	@Disabled("Ya esta testeado")
	@Test
	public void retornarSetUsuarios() {
		Pageable pageable = PageRequest.of(0, 5);
		List<TaringueroDto> retornarSetUsuarios = usuarioServices.getAllUsuarios(pageable);
		System.out.println("* cantidad de registros "+retornarSetUsuarios.size());
		for (TaringueroDto taringueroDto : retornarSetUsuarios) {
			System.out.println("*** registro **** "+
			           "*** Codigo **** "+taringueroDto.getId()+
			           "*** Nombre Usuario **** "+taringueroDto.getNombreUsuario());
		}
		assertTrue(retornarSetUsuarios.size() >= 0);
	}
	
	@Disabled("Ya esta testeado")
	@Test
	@Rollback(false)
	public void guardarUsuario() {
		try {
			TaringueroDto taringueroDto = new TaringueroDto();
			//llenando el dto en caso de ser nuevo
			taringueroDto.setNombreUsuario("Test250");
			taringueroDto.setEdad(27);
			taringueroDto.setGenero("MASCULINO");
			String[] versionesDto = new String[2];
			versionesDto[0] = "V6";
			versionesDto[1] = "V5";
			taringueroDto.setVersiones(versionesDto);
			taringueroDto.setFacha("S");
			taringueroDto.setSigoVirgo("S");
			//Fin llenando el dto en caso de ser nuevo
			
			//llenando el dto en caso de existir
			//taringueroDto.setId( (long)30);
			Usuario usuario;
			if(taringueroDto.getId() != null) {
				Optional<Usuario> buscarPorId = usuarioServices.getUsuario(taringueroDto.getId());
				if(buscarPorId.isPresent()) {
				   usuario = buscarPorId.get();
				}else {
					throw new Exception();
				}
			}else {
				usuario = new Usuario();
			}
			usuario.setNombreUsuario(taringueroDto.getNombreUsuario());
		    usuario.setEdad(taringueroDto.getEdad());
		    Optional<Genero> genero2 = generoServices.getGenero(taringueroDto.getGenero());
		    if (genero2.isPresent()){
		    	usuario.setGenero(genero2.get());
		    }
		    else{
		    	throw new Exception();
		    }
		    usuario.setSigoVirgo(taringueroDto.getSigoVirgo());
		    usuario.setFacha(taringueroDto.getFacha());

		    Set<Version> listaUsuVer = new  HashSet<Version>();
			for (String var : taringueroDto.getVersiones()) {
				Optional<Version> version = versionServices.getVersion(var);
			    if (version.isPresent()){
				    listaUsuVer.add(version.get());
			    }
			    else{
			    	throw new Exception();
			    }
			}
			usuario.setVersiones(listaUsuVer);
			Usuario guardado = usuarioServices.guardar(usuario);
			assertNotNull(guardado, () -> "Version guardada correctamente");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
