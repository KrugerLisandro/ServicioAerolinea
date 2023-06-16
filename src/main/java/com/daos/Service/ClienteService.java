package com.daos.Service;

import java.util.List;
import java.util.Optional;

import com.daos.Entity.Cliente;
import com.daos.Exception.Excepcion;


public interface ClienteService {
	
	/**
	 * Servicio para listar todos los clientes
	 * @return
	 */

	public List<Cliente> obtenerClientes();
	
	/**
	 * Servicio para listar datos de un cliente
	 * @param dni Un Cliente se identifica con el dni que sera unico
	 * @return null o datos del cliente
	 */
	
	public Optional<Cliente> obtenerClientebyDNI(Long dni);
	
	/**
	 * Servicio para guardar un cliente
	 * @param cliente
	 * @return
	 * @throws Excepcion
	 */

	public Cliente insertarCliente (Cliente cliente) throws Excepcion;
	
	/**
	 * Servicio para modificar los datos de un cliente
	 * @param cliente
	 * @return
	 * @throws Excepcion
	 */
	
	public Cliente actualizarCliente (Cliente cliente) throws Excepcion;
	
	/**
	 * Servicio para eliminar un cliente
	 * @param cliente
	 * @return
	 * @throws Excepcion
	 */
	
	public void  elminarCliente (long dni) throws Excepcion;

}
