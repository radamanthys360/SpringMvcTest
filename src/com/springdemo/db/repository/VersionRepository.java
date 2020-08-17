package com.springdemo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springdemo.db.entity.Version;

public interface VersionRepository<P> extends JpaRepository<Version,String>{
}