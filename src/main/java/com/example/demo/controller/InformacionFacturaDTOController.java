package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InformacionFacturaDTO;
import com.example.demo.service.InformacionFacturaDTOService;

@RestController
@RequestMapping("/api/informacionFactura")
@CrossOrigin(origins="*")
public class InformacionFacturaDTOController {
	
	@Autowired
	InformacionFacturaDTOService informacionFacturaDTOService;
	
	//EndPoint: localhost:9898/api/informacionFactura/buscarFactura/#
	
	@GetMapping("/buscarFactura/{id}")
	public List<InformacionFacturaDTO> buscarFacturaPorId(@PathVariable("id") int id) {
		return informacionFacturaDTOService.getDatosFactura(id);
		//return "prueba con valor: "+id;
	}
	

}
