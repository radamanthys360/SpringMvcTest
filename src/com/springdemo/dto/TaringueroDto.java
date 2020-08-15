package com.springdemo.dto;


import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaringueroDto {

	private Long id;
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String nombreUsuario;
	
	private Integer edad;
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String genero;
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String sigoVirgo;
	
	private String facha;
	
	private String[] versiones;
	private String versionestexto;
	
	//paginacion
	private List<Integer> datosPaginador;
	
	public TaringueroDto() {
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSigoVirgo() {
		return sigoVirgo;
	}

	public void setSigoVirgo(String sigoVirgo) {
		this.sigoVirgo = sigoVirgo;
	}

	public String getFacha() {
		return facha;
	}

	public void setFacha(String facha) {
		this.facha = facha;
	}

	public String[] getVersiones() {
		return versiones;
	}

	public void setVersiones(String[] versiones) {
		this.versiones = versiones;
	}

	public String getVersionestexto() {
		return versionestexto;
	}

	public void setVersionestexto(String versionestexto) {
		this.versionestexto = versionestexto;
	}

	public List<Integer> getDatosPaginador() {
		return datosPaginador;
	}

	public void setDatosPaginador(List<Integer> datosPaginador) {
		this.datosPaginador = datosPaginador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
