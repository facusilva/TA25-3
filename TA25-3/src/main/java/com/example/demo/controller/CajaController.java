package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Caja;
import com.example.demo.service.CajaServiceImpl;

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
public class CajaController {

	@Autowired
	CajaServiceImpl CajaServiceImpl;
	
	//listar todos los Cajas
	@GetMapping("/cajas")
	public List<Caja> listarCajas(){
		return CajaServiceImpl.listarCajas();
	}
	
	//guardar un Caja
	@PostMapping("/cajas")
	public Caja salvarCaja(@RequestBody Caja Caja) {//los datos del Caja llegan en formato JSON desde el Request Body
		return CajaServiceImpl.guardarCaja(Caja);
	}
	
	//muestro un Caja según el ID indicada
	@GetMapping("/cajas/{id}") 
	public Caja CajaXID(@PathVariable(name="id") Long id){ // el id del Caja llega desde la variable del path
		Caja Caja_xid = new Caja();//creo una instancia de la clase Caja
		
		Caja_xid=CajaServiceImpl.CajaXID(id);//busco el Caja según el ID y le asigno los datos a la instancia de la clase Caja
		
		System.out.println("Caja XID: "+Caja_xid);
		
		return Caja_xid;//devuelvo el Caja en formato JSON
	}
	
	//Actualizo los datos de un Caja según el ID indicada
	@PutMapping("/cajas/{id}")
	public Caja actualizarCaja(@PathVariable(name="id")Long id,@RequestBody Caja Caja) {
		
		Caja Caja_seleccionado= new Caja();
		Caja Caja_actualizado= new Caja();
		
		Caja_seleccionado= CajaServiceImpl.CajaXID(id);
		
		Caja_seleccionado.setContenido(Caja.getContenido());
		Caja_seleccionado.setValor(Caja.getValor());
		Caja_seleccionado.setAlmacen(Caja.getAlmacen());
		
		Caja_actualizado = CajaServiceImpl.actualizarCaja(Caja_seleccionado);
		
		System.out.println("El Caja actualizado es: "+ Caja_actualizado);
		
		return Caja_actualizado;
	}
	
	//borro el Caja indicado por el ID que llega en la variable del path
	@DeleteMapping("/cajas/{id}")
	public void eleiminarCaja(@PathVariable(name="id")Long id) {
		CajaServiceImpl.eliminarCaja(id);
	}
}
