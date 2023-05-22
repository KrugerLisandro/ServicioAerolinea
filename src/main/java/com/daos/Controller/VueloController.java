package com.daos.Controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.daos.Entity.Vuelo;
import com.daos.Request.VueloRequest;
import com.daos.Response.VueloDTO;
import com.daos.Service.VueloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vuelo")
public class VueloController {
	
	@Autowired
	VueloService vueloService;
	
	//GET
	//OBTENER TODOS LOS VUELOS.
	//¿ES NECESARIO AGREGAR EL VALUE EN ESTE CASO?
	@GetMapping(value="/*", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<VueloDTO>> obtenerVuelos() {
		
		Optional <List<Vuelo>> vuelosList = vueloService.ObtenerVuelosOptional();
		if(vuelosList.isPresent()) {
			List<Vuelo> vuelos = vuelosList.get();
			return new ResponseEntity<List<VueloDTO>>(buildListResponse(vuelos), HttpStatus.OK);
 		}
		
		//¿QUE HACE EL METODO BUILD()?
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	private List<VueloDTO> buildListResponse(List<Vuelo> vuelos) {
		
		List<VueloDTO> vuelosDTO = new ArrayList<VueloDTO>();
		for (Vuelo v : vuelos) {
			vuelosDTO.add(new VueloDTO(v));
		}
		
		return vuelosDTO;
	}

	//MODIFICAR VUELO POR VUELODTO
	//OBTENER EMPLEADO
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<VueloDTO> obtenerVuelo(@PathVariable Long nro){
		
		Optional<Vuelo> vueloRta = vueloService.obtenerVueloOptional(nro);
		if(vueloRta.isPresent()) {
			Vuelo vuelo = vueloRta.get(); 
			return new ResponseEntity<VueloDTO>(buildResponse(vuelo), HttpStatus.OK);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	private VueloDTO buildResponse(Vuelo vuelo) {
		
		return new VueloDTO(vuelo);
	}

	// POST 
	@PostMapping
	public ResponseEntity<Object> guardarVuelo(@Valid @RequestBody VueloRequest vueloRequest, BindingResult result){
		
		if(result.hasErrors()) {
			//AGREGAR EXCEPTION
		}
		
		Vuelo newVuelo = vueloRequest.toEntidad();
		vueloService.guardarVuelo(newVuelo);
		
		return new ResponseEntity<Object>(newVuelo, HttpStatus.CREATED);
	}
	
	// PUT 
	@PutMapping("/{dni}")
	public ResponseEntity<Object> actualizarVuelo(@Valid @RequestBody VueloRequest vueloRequest, @PathVariable Long nro){
		
		Optional<Vuelo> vueloRta = vueloService.obtenerVueloOptional(nro);
		if(!vueloRta.isPresent()){
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO ENCONTRAR EL VUELO QUE DESEA MODIFICAR.");
		}
		
		Vuelo newVuelo = vueloRequest.toEntidad();
		
		vueloService.guardarVuelo(newVuelo);
		
		return new ResponseEntity<Object>(newVuelo, HttpStatus.OK);
	}
	
	// DELETE
	@DeleteMapping("/{dni}")
	public ResponseEntity<Object> eliminarVuelo(@PathVariable Long nro){
		
		Optional<Vuelo> vueloRta = vueloService.obtenerVueloOptional(nro);
		if(!vueloRta.isPresent()){
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SE PUDO ENCONTRAR EL VUELO QUE DESEA ELIMINAR.");
		}
		
		//MODIFICAR EL ESTADO DEL VUELO A CANCELADO.
		
		return null;
	}
}
