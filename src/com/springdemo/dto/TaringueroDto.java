package com.springdemo.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaringueroDto {
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String nombreUsuario;
	
	private Integer edad;
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String genero;
	
	
	private LinkedHashMap<String, String> generoOptions;
	
	@NotNull(message="Es requerido")
	@Size(min=1, message="Es requerido")
	private String sigoVirgo;
	
	private String facha;
	
	private String[] versiones;
	private List<String> versionesData;
	
	public TaringueroDto() {
		//para llenar combo de genero
		generoOptions = new LinkedHashMap<>();
		generoOptions.put("", "Selecciona uno");
		generoOptions.put("M", "Masculino");
		generoOptions.put("F", "Femenino");
		generoOptions.put("NS", "No Sabe");
		
		//versiones de taringa existentes
		versionesData = new ArrayList<String>();
		versionesData.add("V1");
		versionesData.add("V2");
		versionesData.add("V3");
		versionesData.add("V4");
		versionesData.add("V5");
		versionesData.add("V6");
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

	public LinkedHashMap<String, String> getGeneroOptions() {
		return generoOptions;
	}

	public void setGeneroOptions(LinkedHashMap<String, String> generoOptions) {
		this.generoOptions = generoOptions;
	}

	public List<String> getVersionesData() {
		return versionesData;
	}

	public void setVersionesData(List<String> versionesData) {
		this.versionesData = versionesData;
	}

}
