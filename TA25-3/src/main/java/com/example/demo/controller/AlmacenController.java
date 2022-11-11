package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Almacen;
import com.example.demo.service.AlmacenServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlmacenController {

	@Autowired
	AlmacenServiceImpl AlmacenServiceImpl;
	
	//listar todos los Almacenes
	@GetMapping("/almacenes")
	public List<Almacen> listarAlmacenes(){
		return AlmacenServiceImpl.listarAlmacenes();
	}
	
	//guardar un Almacen
	@PostMapping("/almacenes")
	public Almacen salvarAlmacen(@RequestBody Almacen Almacen) {//los datos del Almacen llegan en formato JSON desde el Request Body
		return AlmacenServiceImpl.guardarAlmacen(Almacen);
	}
	
	//muestro un Almacen según el ID indicada
	@GetMapping("/almacenes/{id}") 
	public Almacen AlmacenXID(@PathVariable(name="id") Long id){ // el id del Almacen llega desde la variable del path
		Almacen Almacen_xid = new Almacen();//creo una instancia de la clase Almacen
		
		Almacen_xid=AlmacenServiceImpl.AlmacenXID(id);//busco el Almacen según el ID y le asigno los datos a la instancia de la clase Almacen
		
		System.out.println("Almacen XID: "+Almacen_xid);
		
		return Almacen_xid;//devuelvo el Almacen en formato JSON
	}
	
	//Actualizo los datos de un Almacen según el ID indicada
	@PutMapping("/almacenes/{id}")
	public Almacen actualizarAlmacen(@PathVariable(name="id")Long id,@RequestBody Almacen Almacen) {
		
		Almacen Almacen_seleccionado= new Almacen();
		Almacen Almacen_actualizado= new Almacen();
		
		Almacen_seleccionado= AlmacenServiceImpl.AlmacenXID(id);
		
		Almacen_seleccionado.setLugar(Almacen.getLugar());
		Almacen_seleccionado.setCapacidad(Almacen.getCapacidad());
		Almacen_seleccionado.setCaja(Almacen.getCaja());
		
		Almacen_actualizado = AlmacenServiceImpl.actualizarAlmacen(Almacen_seleccionado);
		
		System.out.println("El Almacen actualizado es: "+ Almacen_actualizado);
		
		return Almacen_actualizado;
	}
	
	//borro el Almacen indicado por el ID que llega en la variable del path
	@DeleteMapping("/almacenes/{id}")
	public void eleiminarAlmacen(@PathVariable(name="id")Long id) {
		AlmacenServiceImpl.eliminarAlmacen(id);
	}
}
