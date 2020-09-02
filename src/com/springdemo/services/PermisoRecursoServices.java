package com.springdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springdemo.db.entity.PermisoRecurso;
import com.springdemo.db.repository.PermisoRecursoRepository;

@Service
public class PermisoRecursoServices {

	@Autowired
	private PermisoRecursoRepository<PermisoRecurso> permisoRecursoRepository;
	
	public Object[][] findPermisoRecurso() {
		return permisoRecursoRepository.findPermisoRecurso();
	}
	
}
