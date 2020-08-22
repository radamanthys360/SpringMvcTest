package com.springdemo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDto {
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String usuario;
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String clave;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
