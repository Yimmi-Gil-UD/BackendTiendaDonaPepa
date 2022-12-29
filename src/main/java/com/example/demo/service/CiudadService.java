package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ciudad;
import com.example.demo.repository.ICiudadDao;

@Service
public class CiudadService {
	
	@Autowired
	ICiudadDao iCiudadDao;
	
	public List<Ciudad> listarCiudades(){
		return (List<Ciudad>) iCiudadDao.findAll();
	}

}
