package com.springdemo.db.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VERSION")
public class Version {
	
    @Id
	@Column(name = "CODIGO", updatable = false, nullable = false)
	private String codigo;
    
	@Column(name="DESCRIPCION", length=50)
	private String descripcion;
	
	public Version() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCodigo());
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Version)) return false;
        Version obj = (Version) o;
        return Objects.equals(getCodigo(), obj.getCodigo());
	}

}
