package com.springdemo.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENERO")
public class Genero {
	
    @Id
    private String tipo;
    
    public Genero(String tipo) {
		this.tipo = tipo;
	}
    
    public Genero() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
