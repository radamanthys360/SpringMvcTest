package com.springdemo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springdemo.db.entity.Users;
import java.lang.String;

public interface UserRepository<P> extends JpaRepository<Users,String> {
    
    Users findByUsername(String username);
    
	@Query(value = "SELECT authority FROM authorities " + 
			       " where username = :usuario ", 
	   nativeQuery = true)
    Object[][] findRoles(@Param("usuario") String usuario);
	
}
