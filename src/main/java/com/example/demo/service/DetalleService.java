package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Detalle;
import com.example.demo.repository.IDetalleDao;

@Service
public class DetalleService {
	
	@Autowired
	IDetalleDao iItemFacturaDao;
	
	public Detalle guardar(Detalle detalle) {
		return iItemFacturaDao.save(detalle);
	}
	
	public Detalle obtener(Integer id) {
		return iItemFacturaDao.findById(id).orElse(null);
	}
	
	public List<Detalle> listar(){
		return (List<Detalle>) iItemFacturaDao.findAll();
	}
	
	public List<Detalle> obtenerPorFactura(int id) {
		return iItemFacturaDao.BuscarDetallePorFactura(id);
	}

}
