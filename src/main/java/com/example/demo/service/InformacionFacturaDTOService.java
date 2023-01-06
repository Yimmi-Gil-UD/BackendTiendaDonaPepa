package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InformacionFacturaDTO;
import com.example.demo.repository.IFacturaDao;


@Service
public class InformacionFacturaDTOService {
	
	
	@Autowired
	IFacturaDao iFacturaDao;
	
	public List<InformacionFacturaDTO> getDatosFactura(int id) {
		return iFacturaDao.buscarDatosFacturaPorId(id);
	}
	
	

}
