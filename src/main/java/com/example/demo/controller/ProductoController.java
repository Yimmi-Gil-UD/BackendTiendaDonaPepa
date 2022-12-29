package com.example.demo.controller;

import java.util.List;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping(value = "/api/productos")
@CrossOrigin(origins="*")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;
	
	@PostMapping(value = "/guardar")
	public Producto guardarProducto(@RequestBody Producto producto) {
		return productoService.saveProducto(producto);
	}
	
	@PostMapping(value = "/guardarTodo")
	public boolean guardarProductos(@RequestBody List<Producto> productos) {
		return productoService.saveProductos(productos);
	}
	
	@GetMapping("/obtenerId/{id}")
	public Producto encontrarProductoId(@PathVariable("id") Integer id) {
		return productoService.encontrarProductoId(id);
	}
	
	@GetMapping(value = "/obtenerPorNombre")
	public Producto encontrarProductoNombre(String nombre) {
		return productoService.encontrarProductoNombre(nombre);
	}
	
	@GetMapping(value = "/obtenerProductosMenores")
	public List<Producto> productosMenoresPrecio(Double precio){
		return productoService.obtenerProductosMenoresAlPrecio(precio);
	}
	
	@GetMapping(value = "/listar")
	public List<Producto> obtenerProductos(){
		return productoService.listarTodo();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminarProducto(@PathVariable("id") int id) {
		return productoService.eliminarPorId(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public boolean actualizarProducto(@PathVariable("id") int id, @RequestBody Producto producto){
		if(!productoService.existePorId(id)) {
			//return  "no existe el producto";
			return true;
		}
		Producto productoObj = productoService.encontrarProductoId(id);
		productoObj.setNombre(producto.getNombre());
		productoObj.setPrecio(producto.getPrecio());
		productoObj.setStock(producto.getStock());
		productoObj.setCategoria(producto.getCategoria());
		productoService.saveProducto(productoObj);
		//return "Producto Actualizado";
		return false;
		
	}
	
	/*@PostMapping("/actualizar/{id}")
	public String actualizarProducto(@PathVariable("id") int id, @RequestBody Producto producto){
		if(!productoService.existePorId(id)) {
			return  "no existe el producto";
		}
		Producto productoObj = productoService.encontrarProductoId(id);
		productoObj.setNombre(producto.getNombre());
		productoObj.setPrecio(producto.getPrecio());
		productoObj.setStock(producto.getStock());
		productoObj.setCategoria(producto.getCategoria());
		productoService.saveProducto(productoObj);
		return "Producto Actualizado";
	}*/

}
