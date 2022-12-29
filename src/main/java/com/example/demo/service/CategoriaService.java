package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Categoria;
import com.example.demo.repository.ICategoriaDao;

@Service
public class CategoriaService {
	
	@Autowired
	ICategoriaDao iCategoriaDao;
	
	public List<Categoria> listar() {
		return (List<Categoria>) iCategoriaDao.findAll();
	}

}
