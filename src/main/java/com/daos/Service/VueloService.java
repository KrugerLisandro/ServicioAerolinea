package com.daos.Service;

import java.util.List;
import java.util.Optional;

import com.daos.Entity.Vuelo;
import com.daos.Exception.Excepcion;


public interface VueloService {

	// OBTENER LA LISTA DE VUELOS
	List<Vuelo> obtenerVuelos();
	
	// OBTENER LA LISTA POR ESTADO
	List<Vuelo> filtroEstado(String estado);
	
	//OBTENER EL ESTADO DE UN VUELO A PARTIR DE SU ID
	String findByVueloEstado(Long nro);
	
	// OBTENER UN VUELO OPTIONAL A PARTIR DE SU ID
	Optional<Vuelo> obtenerVueloOptional(Long nro);

	// DAR DE ALTA, ACTUALIZAR O ELIMINAR DE FORMA LOGICA UN VUELO
	Vuelo guardarVuelo(Vuelo vuelo);
	
	// ACTUALIZAR O ELIMINAR UN VUELO.
	Vuelo actualizarVuelo(Vuelo vuelo)throws Excepcion;
}
