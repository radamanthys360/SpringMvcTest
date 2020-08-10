package com.springdemo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.db.entity.Genero;


public interface GeneroRepository<P> extends JpaRepository<Genero,String>{
}
