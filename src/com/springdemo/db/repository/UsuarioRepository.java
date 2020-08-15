package com.springdemo.db.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springdemo.db.entity.Usuario;

public interface UsuarioRepository <P> extends JpaRepository<Usuario,Long>{
	
    @Query(value = "select usu from Usuario usu where usu.nombreUsuario like %:texto% or usu.genero.tipo like %:texto% or "
    		     + "usu.sigoVirgo like %:texto% or usu.facha like %:texto% or usu.edad like %:texto%")
    Page<Usuario> busquedaTotal(@Param("texto") String texto, Pageable pageable);
	
}
