package com.daos.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.daos.Controller.Errors.ErrorHandler;
import com.daos.Entity.Cliente;
import com.daos.Exception.Excepcion;
import com.daos.Request.ClienteRequest;
import com.daos.Response.ClienteDTO;
import com.daos.Service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService serviceCliente;
	/**
	 * Metodo Get que devuelve Listado de Clientes
	 * @return
	 * @throws Excepcion 
	 */
	@GetMapping(value = "/liscli", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ClienteDTO>> obtenerClientes() throws Excepcion {
		List<Cliente> clientesList = serviceCliente.obtenerClientes();
		if (clientesList != null && !clientesList.isEmpty()) {
			return new ResponseEntity<List<ClienteDTO>>(buildResponseList(clientesList), HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	/**
	 * Metodo get que devuelve datos del dni enviado en el path
	 * @param dni
	 * @return
	 * @throws Excepcion
	 */
	@GetMapping(value = "/{dni}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClienteDTO> obtenerClientebyDNI(@PathVariable Long dni) throws Excepcion {

		Optional<Cliente> clienteRta = serviceCliente.obtenerClientebyDNI(dni);
		if (clienteRta.isPresent()) {
			Cliente cliente = clienteRta.get();		
			return new ResponseEntity<ClienteDTO>(buildResponse(cliente), HttpStatus.OK);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	/**
	 * Metodo Delete que elimina el mail enviado en el path
	 */
	@DeleteMapping("/{dni}")
	public ResponseEntity<Object> eliminarCliente(@PathVariable Long dni) throws Excepcion {

		Optional<Cliente> clienteRta = serviceCliente.obtenerClientebyDNI(dni);
		if (!clienteRta.isPresent())
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO ENCONTRAR EL CLIENTE.");		
		serviceCliente.elminarCliente(dni);
		return ResponseEntity.ok().build();
	}
	/**
	 * metodo post para agregar un cliente en la bd
	 * @param clienteRequest
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Object> insertarCliente (@Valid @RequestBody ClienteRequest clienteRequest,
			BindingResult result) throws Exception {

		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorHandler.formatearErrors(result));
		}			
		Cliente newCliente = clienteRequest.toEntidad();
		serviceCliente.insertarCliente(newCliente);
		return new ResponseEntity<Object>(buildResponse(newCliente), HttpStatus.OK);
	}

	/**
	 * Metodo PUT para actualizar datos de un cliente
	 * @param clienteRequest
	 * @param dni No se permite modificar el dni de la persona
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{dni}")
	public ResponseEntity<Object> actualizarCliente(@RequestBody ClienteRequest clienteRequest, @PathVariable long dni) throws Exception {
		Optional<Cliente> clienteRta = serviceCliente.obtenerClientebyDNI(dni);
		if (!clienteRta.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO ENCONTRAR EL CLIENTE");
		} else {
			Cliente cliente = clienteRequest.toEntidad();
			if (!cliente.getDni().equals(dni))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se puede modificar el dni.");
			serviceCliente.actualizarCliente(cliente);
			return new ResponseEntity<Object>(buildResponse(cliente), HttpStatus.OK);

		}
	}
	/**
	 * Se utiliza para implementar HATEOAS
	 * @param pojo
	 * @return
	 * @throws Excepcion
	 */
	private ClienteDTO buildResponse(Cliente pojo) throws Excepcion {
		try {
			ClienteDTO dto = new ClienteDTO(pojo);
			 //Self link
			Link selfLink = WebMvcLinkBuilder.linkTo(ClienteRestController.class)
										.slash(pojo.getDni())                
										.withSelfRel();
			dto.add(selfLink);
			return dto;
		} catch (Exception e) {
			throw new Excepcion(e.getMessage(),500);
		}
	}
	private List<ClienteDTO> buildResponseList(List<Cliente> pojo) throws Excepcion {
		try {
			List<ClienteDTO> listCliDTO = new ArrayList<ClienteDTO>();
			for (Cliente cliente : pojo) {
				ClienteDTO dto = new ClienteDTO(cliente);
				 //Self link
				Link selfLink = WebMvcLinkBuilder.linkTo(ClienteRestController.class)
											.slash(cliente.getDni())                
											.withSelfRel();
				
				listCliDTO.add(dto.add(selfLink));
				
			}
			
			return listCliDTO;
		} catch (Exception e) {
			throw new Excepcion(e.getMessage(),500);
		}
	}
}
