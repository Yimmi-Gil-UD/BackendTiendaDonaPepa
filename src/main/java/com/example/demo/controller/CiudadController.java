package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ciudad;
import com.example.demo.service.CiudadService;

@RestController
@RequestMapping("/api/ciudad")
@CrossOrigin(origins="*")
public class CiudadController {
	
	@Autowired
	CiudadService ciudadService;
	
	@GetMapping("/listar")
	public List<Ciudad> findAllCiudad(){
		return ciudadService.listarCiudades();
	}

}
