package com.springdemo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springdemo.db.entity.Users;
import java.lang.String;

public interface UserRepository<P> extends JpaRepository<Users,String> {
    
    Users findByUsername(String username);
	
}
