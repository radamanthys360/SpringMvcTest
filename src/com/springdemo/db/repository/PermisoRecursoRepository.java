package com.springdemo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springdemo.db.entity.PermisoRecurso;

public interface PermisoRecursoRepository <P> extends JpaRepository<PermisoRecurso,Long>{

	@Query(value = "SELECT DISTINCT(recurso), " + 
			       "(select LISTAGG(pr2.authorities,',') WITHIN GROUP (ORDER BY pr2.authorities) " + 
			       "from PERMISO_RECURSO pr2 where pr2.recurso = pr1.recurso) AUTHORITIES " + 
			       "FROM PERMISO_RECURSO pr1 WHERE pr1.ACTIVO = 'S' ", 
		   nativeQuery = true)
	       Object[][] findPermisoRecurso();
}
