package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Producto;
import com.example.demo.repository.IClienteDao;

@Service
public class ClienteService {

	@Autowired
	IClienteDao iClienteDao;
	
	public Cliente crearCliente(Cliente cliente) {
		return iClienteDao.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return (List<Cliente>) iClienteDao.findAll();
	}
	
	public boolean existePorId(int id) {
		return iClienteDao.existsById(id);
	}
	
	public Cliente encontrarClienteId(int id) {
		return iClienteDao.findById(id).orElse(null);
	}
	
	public boolean eliminarPorId(int id) {
		try {
			iClienteDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Cliente encontrarPorDocumento(int documento) {
		return iClienteDao.existsByDocumento(documento);
	}
	

}
