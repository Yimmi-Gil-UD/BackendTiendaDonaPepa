package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Detalle;
import com.example.demo.service.DetalleService;

@RestController
@RequestMapping(value = "/api/detalle")
@CrossOrigin(origins="*")
public class DetalleController {

	@Autowired
	DetalleService itemFacturaService;
	
	@PostMapping(value = "/guardar")
	public Detalle guardarItem(@RequestBody Detalle detalle) {
		return itemFacturaService.guardar(detalle);
	}
	
	@GetMapping(value = "/obtenerId")
	public Detalle obtenerItem(Integer id) {
		return itemFacturaService.obtener(id);
	}
	
	@GetMapping(value ="/listar")
	public List<Detalle> listarDetalle(){
		return itemFacturaService.listar();
	}
	
	@GetMapping(value = "/obtenerPorFactura/{id}")
	public List<Detalle> obtenerItemFactura(@PathVariable("id") int id) {
		return itemFacturaService.obtenerPorFactura(id);
	}
	
}
