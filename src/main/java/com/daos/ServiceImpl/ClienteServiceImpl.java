package com.daos.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daos.Service.ClienteService;
import com.daos.Entity.Cliente;
import com.daos.Exception.Excepcion;
import com.daos.Repository.ClienteDAO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private ClienteDAO ClienteDao;
	
	@Override
	public List<Cliente> obtenerClientes() {
		return ClienteDao.findAll();
	}
	@Override
	public Optional<Cliente> obtenerClientebyDNI(Long dni){
		return ClienteDao.findById(dni);
	}
	
	@Override
	public Cliente insertarCliente (Cliente cliente) throws Excepcion {
		
		Set<ConstraintViolation<Cliente>> constraintViolation = validator.validate(cliente);
		if(constraintViolation.size()>0)
		{
			String errors="";
			for (ConstraintViolation<Cliente> cv : constraintViolation) {
				errors+= cv.getPropertyPath() + ": " + cv.getMessage() + "\n";
			}
			throw new Excepcion(400, errors);
		}
		
		if (existeCliente(cliente.getDni())) {
			throw new Excepcion("YA EXISTE UN CLIENTE CON ESE DNI.");
		}
		
		return ClienteDao.save(cliente);
	}
	
	@Override
	public Cliente actualizarCliente (Cliente cliente) throws Excepcion{	
		return ClienteDao.save(cliente);
	}
	
	private boolean existeCliente (Long dni) {
		boolean band = false;
		Long dniCliente = ClienteDao.findBydni(dni);
		if (dniCliente != null)
			band = true;
		return band;
	}

	@Override
	public void elminarCliente (long dni) {
		ClienteDao.deleteById(dni);
	}
}
