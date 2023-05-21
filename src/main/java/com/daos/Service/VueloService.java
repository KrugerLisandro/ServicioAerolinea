package com.daos.Service;

import java.util.List;

import com.daos.Entity.Vuelo;


public interface VueloService {

	// OBTENER LA LISTA DE VUELOS
	List<Vuelo> obtenerVuelos();

	// OBTENER UN VUELO A PARTIR DE SU ID
	Vuelo obtenerVuelos(Long id);

	// DAR DE ALTA O ACTUALIZAR UN VUELO
	Vuelo guardarVuelo(Vuelo vuelo);

	// ELIMINAR UN VUELO.
	void eliminarVuelo(Vuelo vuelo);
}
