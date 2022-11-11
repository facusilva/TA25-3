package com.example.demo.dto;

import javax.persistence.*;

@Entity
@Table(name="caja")
public class Caja {

	//atributos de la entidad fabricante
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenido;
	private int valor;
	
	@ManyToOne
	@JoinColumn(name="almacen")
	private Almacen almacen;

	
	//constructores
	
	public Caja() {
	}

	public Caja(Long id, String contenido, int valor, Almacen almacen) {
		this.id = id;
		this.contenido = contenido;
		this.valor = valor;
	}

	//getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	

	
	

	
	
	
	
	
	
}
