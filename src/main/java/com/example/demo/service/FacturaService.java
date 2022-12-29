package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Factura;
import com.example.demo.repository.IFacturaDao;

@Service
public class FacturaService {
	
	@Autowired
	IFacturaDao iFacturaDao;
	
	public Factura nuevaFactura(Factura factura) {
		return iFacturaDao.save(factura);
	}
	
	public Factura obtenerFactura(Integer id) {
		return iFacturaDao.findById(id).orElse(null);
	}
	

}
