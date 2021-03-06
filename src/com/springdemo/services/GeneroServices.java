package com.springdemo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
	
	@Transactional
	public Optional<Genero> getGenero(String id) {
		return  Optional.ofNullable(generoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id)));
	}
	
}
