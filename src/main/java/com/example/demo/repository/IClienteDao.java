package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Producto;

@Repository
public interface IClienteDao extends CrudRepository<Cliente, Integer>{
	
	//List<Cliente> existsByDocumento(int documento);
	
	@Query(value = "select * from cliente where documento = ?", nativeQuery = true)
	public Cliente existsByDocumento(int documento);

}
