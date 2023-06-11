package com.daos.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daos.Controller.Errors.ErrorHandler;
import com.daos.Entity.Vuelo;
import com.daos.Exception.Excepcion;
import com.daos.Request.VueloRequest;
import com.daos.Response.VueloDTO;
import com.daos.Service.VueloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vuelo")
public class VueloController {
	
	@Autowired
	private VueloService serviceVuelo;
	
	//GET
	//OBTENER TODOS LOS VUELOS.
	@GetMapping(value="/list", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Vuelo>> obtenerVuelos() {
		
		List<Vuelo> vuelosList = serviceVuelo.obtenerVuelos();
		if(vuelosList != null && !vuelosList.isEmpty()) {
			return new ResponseEntity<List<Vuelo>>(vuelosList, HttpStatus.OK);
 		}
		
		//BUILD: SE UTILIZA PARA CONSTRUIR UNA RESPUESTA SIN CONTENIDO CON EL ESTADO NOT_FOUND.
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Vuelo>> filtroEstado(@RequestParam(name = "estado") String estado) throws Excepcion {
		
		List<Vuelo> vuelosList = serviceVuelo.filtroEstado(estado);
		if(vuelosList != null && !vuelosList.isEmpty()) {
			return new ResponseEntity<List<Vuelo>>(vuelosList, HttpStatus.OK);
 		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	//MODIFICAR VUELO POR VUELODTO
	//OBTENER EMPLEADO
	@GetMapping(value = "/{nro}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<VueloDTO> obtenerVuelo(@PathVariable Long nro){
		
		Optional<Vuelo> vueloRta = serviceVuelo.obtenerVueloOptional(nro);
		if(vueloRta.isPresent()) {
			Vuelo vuelo = vueloRta.get(); 
			return new ResponseEntity<VueloDTO>(new VueloDTO(vuelo), HttpStatus.OK);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	// POST 
	@PostMapping
	public ResponseEntity<Object> guardarVuelo(@Valid @RequestBody VueloRequest vueloRequest, BindingResult result) throws Exception{
		
		if(result.hasErrors()) {
			return new ResponseEntity<Object>(ErrorHandler.formatearErrors(result),HttpStatus.BAD_REQUEST); 
		}
		
		Vuelo newVuelo = serviceVuelo.guardarVuelo(vueloRequest.toEntidad());
		
		return new ResponseEntity<Object>(newVuelo, HttpStatus.CREATED);
	}
	
	// PUT 
	@PutMapping("/{nro}")
	public ResponseEntity<Object> actualizarVuelo( @RequestBody VueloRequest vueloRequest, @PathVariable Long nro, BindingResult result) throws Exception{
		
		Optional<Vuelo> vueloRta = serviceVuelo.obtenerVueloOptional(nro);
		if(!vueloRta.isPresent()){
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO SE PUDO ENCONTRAR EL VUELO QUE DESEA MODIFICAR.");
		}
		
		if(vueloRequest.getFecha_hora().isAfter(vueloRta.get().getFecha_hora()) && vueloRequest.getFecha_hora() != null) {
			vueloRta.get().setFecha_hora(vueloRequest.getFecha_hora());
			vueloRta.get().setEstado("reprogramado");
			
			Vuelo newVuelo = serviceVuelo.actualizarVuelo(vueloRta.get());
			
			System.out.println("Se notifico del cambio a los clientes.");
			return new ResponseEntity<Object>(newVuelo, HttpStatus.OK);
		}
		
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fecha_hora: DEBE SER POSTERIOR A LA FECHA ACTUAL Y DEBE SER NO NULA.");
	}
	
	// DELETE
	@DeleteMapping("/{nro}")
	public ResponseEntity<Object> eliminarVuelo(@PathVariable Long nro) throws Excepcion{
		
		Optional<Vuelo> vueloRta = serviceVuelo.obtenerVueloOptional(nro);
		if(!vueloRta.isPresent()){
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO ENCONTRAR EL VUELO QUE DESEA ELIMINAR.");
		}
		
		//MODIFICAR EL ESTADO DEL VUELO A CANCELADO.
		vueloRta.get().setEstado("cancelado");
		Vuelo newVuelo = serviceVuelo.actualizarVuelo(vueloRta.get());
		return new ResponseEntity<Object>(newVuelo, HttpStatus.OK);
	}
}
