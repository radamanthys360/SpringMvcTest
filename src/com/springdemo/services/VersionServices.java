package com.springdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.db.entity.Version;
import com.springdemo.db.repository.VersionRepository;

@Service
public class VersionServices {
	
	@Autowired
	private VersionRepository<Version> versionRepository;
	
	@Transactional
	public List<Version> getAllVersion() {
		return (List<Version>) versionRepository.findAll();
	}
	
	@Transactional
	public Optional<Version> getVersion(String id) {
		return  versionRepository.findById(id);
	}
	
	//son para test
    public String pruebatexto() {
    	return "correcto";
    }
    
    //son para test
    public Double pruebaNumero(Double var1,Double var2) {
    	return (var1*var2);
    }
    
}
