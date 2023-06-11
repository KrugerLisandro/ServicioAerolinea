package com.daos.Service;

import java.util.List;
import java.util.Optional;

import com.daos.Entity.Cliente;
import com.daos.Exception.Excepcion;


public interface ClienteService {

	List<Cliente> obtenerClientes();
	
	Optional<Cliente> obtenerClientebyDNI(Long dni);

	Cliente guardarCliente (Cliente cliente) throws Excepcion;
	
	Cliente actualizarCliente (Cliente cliente) throws Excepcion;
	
	Cliente elminarCliente (Cliente cliente) throws Excepcion;
}
