package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InformacionProductosDTO;
import com.example.demo.entity.Producto;
import com.example.demo.repository.IProductoDao;

@Service
public class ProductoService {

	@Autowired
	IProductoDao iProductoDao;
	
	public Producto saveProducto(Producto producto) {
		return iProductoDao.save(producto);
	}
	
	public boolean saveProductos(List<Producto> productos) {
		try {
			iProductoDao.saveAll(productos);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Producto encontrarProductoId(Integer id) {
		return iProductoDao.findById(id).orElse(null);
	}
	
	public Producto encontrarProductoNombre(String nombre) {
		return iProductoDao.findByNombre(nombre).orElse(null);
	}
	
	public List<Producto> obtenerProductosMenoresAlPrecio(Double precio){
		return iProductoDao.BuscarProductosMenoresAlPrecio(precio);
	}
	
	public List<Producto> listarTodo(){
		return (List<Producto>) iProductoDao.findAll();
	}
	
	public boolean existePorId(int id) {
		return iProductoDao.existsById(id);
	}
	
	public boolean existsByNombre(String nombre) {
		return iProductoDao.existsByNombre(nombre);
	}
	
	public boolean eliminarPorId(int id) {
		try {
			iProductoDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		 
	}
	
	public List<InformacionProductosDTO> productosMasVendidos(){
		return iProductoDao.BuscarProductosMasVendidos();
	}
	
	
	
	
}
