package com.springdemo.db.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	
	@Id
	@Column(name="USERNAME", length=50, nullable=false)
	private String username;
	
	@Column(name="PASSWORD", length=50, nullable=false)
	private String password;
	
	@Column(name="ENABLED", nullable=false)
	private int enabled;

	public Users() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getUsername());
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users obj = (Users) o;
        return Objects.equals(getUsername(), obj.getUsername());
	}
}
