package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Detalle;
import com.example.demo.entity.Producto;

@Repository
public interface IDetalleDao extends CrudRepository<Detalle, Integer>{
	
	@Query(value = "select * from detalle where factura_id <= ?", nativeQuery = true)
	public List<Detalle> BuscarDetallePorFactura(int factura_id);

}
