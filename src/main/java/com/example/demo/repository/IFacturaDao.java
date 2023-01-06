package com.example.demo.repository;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.InformacionFacturaDTO;
import com.example.demo.entity.Factura;

@Repository
public interface IFacturaDao extends CrudRepository<Factura, Integer>{
	
	@Query(value = "select \r\n"
			+ "f.id idFactura\r\n"
			+ ",f.fecha_Creacion fechaCreacionFactura\r\n"
			+ ",dt.cantidad cantidadProductos\r\n"
			+ ",dt.precio precioProducto\r\n"
			+ ",pd.nombre nombreProducto\r\n"
			+ ",c.nombre nombreCategoria\r\n"
			+ ",concat(cl.nombre,' ',cl.apellido) nombreApellidoCliente\r\n"
			+ ",cl.email emailCliente\r\n"
			+ ",cl.telefono telefonoCliente\r\n"
			+ ",cl.documento documentoCliente\r\n"
			+ ",cu.nombre_Ciudad ciudadCliente\r\n"
			+ "from facturas as f\r\n"
			+ "inner join detalle as dt on dt.factura_id = f.id\r\n"
			+ "inner join productos as pd on pd.id = dt.producto_id\r\n"
			+ "inner join categorias as c on c.id_categoria = pd.id_categoria\r\n"
			+ "inner join cliente as cl on cl.id = f.cliente_id\r\n"
			+ "inner join ciudad as cu on cu.id_ciudad = cl.id_ciudad\r\n"
			+ "where f.id = ? ", nativeQuery = true)
	public List<InformacionFacturaDTO> buscarDatosFacturaPorId(int id);

}
