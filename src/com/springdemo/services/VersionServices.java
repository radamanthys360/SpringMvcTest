package com.springdemo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
		return  Optional.ofNullable(versionRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id)));
	}

}
