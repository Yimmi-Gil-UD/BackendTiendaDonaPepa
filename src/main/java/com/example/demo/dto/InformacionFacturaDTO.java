package com.example.demo.dto;

import java.util.Date;

import org.springframework.stereotype.Component;


public interface InformacionFacturaDTO {
	
	
	int getIdFactura();
	Date getFechaCreacionFactura();
	int getCantidadProductos();
	double getPrecioProducto();
	String getNombreProducto();
	String getNombreCategoria();
	String getNombreApellidoCliente();
	String getEmailCliente();
	long getTelefonoCliente();
	long getDocumentoCliente();
	String getCiudadCliente();
	

}
