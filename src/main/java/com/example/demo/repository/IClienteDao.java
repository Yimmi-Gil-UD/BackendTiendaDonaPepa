package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.InformacionClientesDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Producto;

@Repository
public interface IClienteDao extends CrudRepository<Cliente, Integer>{
	
	//List<Cliente> existsByDocumento(int documento);
	
	@Query(value = "select * from cliente where documento = ?", nativeQuery = true)
	public Cliente existsByDocumento(int documento);
	
	//Clientes con mayores compras
	
	@Query(value = "select \r\n"
			+ "f.cliente_id clienteId\r\n"
			+ ",concat(cl.nombre,' ',cl.apellido) nombreCliente\r\n"
			+ ",count(*) cantidadCompras\r\n"
			+ "from facturas as f\r\n"
			+ "inner join cliente as cl on cl.id = f.cliente_id\r\n"
			+ "group by f.cliente_id", nativeQuery = true)
	public List<InformacionClientesDTO> clientesMayoresCompra();

}
