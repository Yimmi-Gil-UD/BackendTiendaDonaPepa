package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ciudad")
public class Ciudad implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCiudad;
	@Column(name = "nombreCiudad")
	private String nombreCiudad;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ciudad", cascade = CascadeType.ALL)
	//@OneToMany
	private List<Cliente> clientes;

	
	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	/*public List<Cliente> getClientes() {
		return clientes;
	}*/

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	

}
