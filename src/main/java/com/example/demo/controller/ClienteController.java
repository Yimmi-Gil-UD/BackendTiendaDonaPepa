package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins="*")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping(value="/crear")
	public Cliente agregarCliente(@RequestBody Cliente cliente) {
		return clienteService.crearCliente(cliente);
	}
	
	@GetMapping("/buscarPorDocumento/{numDocumento}")
	public Cliente buscarClientePorDocumento(@PathVariable("numDocumento") int numDocumento) {
		return clienteService.encontrarPorDocumento(numDocumento);
	}
	
	@GetMapping("/listar")
	public List<Cliente> findAllClientes(){
		return clienteService.listarClientes();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminarPorId(@PathVariable("id") int id) {
		return clienteService.eliminarPorId(id);
	}
	
	
	@PutMapping("/actualizar/{id}")
	public Map<String, String>  actualizarCliente(@PathVariable("id") int id, @RequestBody Cliente cliente) {
		HashMap<String, String> map = new HashMap<>();
		if(!clienteService.existePorId(id)) {
			map.put("response", "no existe el cliente");
			return map;
			//return "no existe el cliente";
		}
		Cliente clienteObj = clienteService.encontrarClienteId(id);
		clienteObj.setNombre(cliente.getNombre());
		clienteObj.setApellido(cliente.getApellido());
		clienteObj.setTelefono(cliente.getTelefono());
		clienteObj.setEmail(cliente.getEmail());
		clienteObj.setCiudad(cliente.getCiudad());
		clienteObj.setDocumento(cliente.getDocumento());
		clienteService.crearCliente(clienteObj);
		map.put("response", "cliente actualizado");
		return map;
		//return "cliente actualizado";
	}
	
}
