package com.springdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.db.entity.Genero;
import com.springdemo.db.repository.GeneroRepository;

@Service
public class GeneroServices {

	@Autowired
	private GeneroRepository<Genero> generoRepository;
	
	@Transactional
	public List<Genero> getAllGenero() {
		return (List<Genero>) generoRepository.findAll();
	}
	
}
