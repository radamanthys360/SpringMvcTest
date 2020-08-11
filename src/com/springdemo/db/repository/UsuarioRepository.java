package com.springdemo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.db.entity.Usuario;

public interface UsuarioRepository <P> extends JpaRepository<Usuario,String>{
}
