package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Factura;
import com.example.demo.service.FacturaService;

@RestController
@RequestMapping(value="/api/factura")
@CrossOrigin(origins="*")
public class FacturaController {
	
	@Autowired
	FacturaService facturaService;
	
	@PostMapping(value="/crear")
	public Factura crearFactura(@RequestBody Factura factura) {
		return facturaService.nuevaFactura(factura);
	}
	
	@GetMapping(value="/obtener")
	public Factura obtenerFactura(Integer id) {
		return facturaService.obtenerFactura(id);
	}

}
