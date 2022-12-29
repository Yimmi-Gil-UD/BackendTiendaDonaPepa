package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Categoria;
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria/")
@CrossOrigin(origins="*")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping("listar")
	public List<Categoria> listarCategorias(){
		return categoriaService.listar();
	}

}
