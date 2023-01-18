package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.InformacionProductosDTO;
import com.example.demo.entity.Producto;

@Repository
public interface IProductoDao extends CrudRepository<Producto, Integer> {

	public Optional<Producto> findByNombre(String nombre);
	
	@Query(value = "select * from productos where precio <= ?", nativeQuery = true)
	public List<Producto> BuscarProductosMenoresAlPrecio(Double precio);
	
	Boolean existsByNombre(String nombre);
	
	//Productos mas vendidos
	@Query(value = "select \r\n"
			+ "dt.producto_id ProductoId\r\n"
			+ ",p.nombre\r\n"
			+ ",Sum(dt.cantidad) cantidadCompras\r\n"
			+ "from detalle as dt\r\n"
			+ "inner join productos as p on p.id = dt.producto_id\r\n"
			+ "group by dt.producto_id", nativeQuery = true)
	public List<InformacionProductosDTO> BuscarProductosMasVendidos();
	
}
