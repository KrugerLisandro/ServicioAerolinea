package com.daos.Service;

import java.util.List;
import java.util.Optional;

import com.daos.Entity.Vuelo;


public interface VueloService {

	// OBTENER LA LISTA DE VUELOS
	List<Vuelo> obtenerVuelos();
	
	// OBTENER LISTA DE VUELOS OPTIONAL
	Optional<List<Vuelo>> ObtenerVuelosOptional();

	// OBTENER UN VUELO A PARTIR DE SU ID
	Vuelo obtenerVuelo(Long nro);
	
	// OBTENER UN VUELO OPTIONAL A PARTIR DE SU ID
	Optional<Vuelo> obtenerVueloOptional(Long nro);

	// DAR DE ALTA O ACTUALIZAR UN VUELO
	Vuelo guardarVuelo(Vuelo vuelo);

	// ELIMINAR UN VUELO.
	void eliminarVuelo(Vuelo vuelo);
}
