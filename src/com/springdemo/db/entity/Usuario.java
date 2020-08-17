package com.springdemo.db.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODIGO", updatable = false, nullable = false)
	private Long codigo;
	
	@Column(name="NOMBRE_USUARIO", length=25, nullable=false)
	private String nombreUsuario;
	
	@OneToOne
    @JoinColumn(name = "FK_GENERO", referencedColumnName = "TIPO")
	private Genero genero;
	
	@Column(name="SIGO_VIRGO", length=1, nullable=false)
	private String sigoVirgo;
	
	@Column(name="FACHA", length=1)
	private String facha;
	
	@Column(name="EDAD")
	private Integer edad;
	
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "USUARIO_VERSION",
            joinColumns = {
                    @JoinColumn(name = "FK_USUARIO", referencedColumnName = "CODIGO",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "FK_VERSION", referencedColumnName = "CODIGO",
                            nullable = false, updatable = false)})
    private Set<Version> versiones = new HashSet<>();
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Set<Version> getVersiones() {
		return versiones;
	}

	public void setVersiones(Set<Version> versiones) {
		this.versiones = versiones;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCodigo());
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario obj = (Usuario) o;
        return Objects.equals(getCodigo(), obj.getCodigo());
	}
	
}
