package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Almacen;

public interface IAlmacenService {

	//Métodos del CRUD
	public List<Almacen> listarAlmacenes(); //Listar All
	
	public Almacen guardarAlmacen(Almacen Almacen); //Guarda un Almacen CREATE
	
	public Almacen AlmacenXID(Long id); //Leer datos de un Almacen READ
	
	public Almacen actualizarAlmacen(Almacen Almacen); //Actualiza datos del Almacen UPDATE
	
	public void eliminarAlmacen(Long id);//Elimina el Almacen DELETE
}
