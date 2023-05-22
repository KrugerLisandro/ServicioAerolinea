package com.daos.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daos.Entity.Vuelo;
import com.daos.Repository.VueloDAO;
import com.daos.Service.VueloService;

@Service
public class VueloServiceImpl implements VueloService {
	
	@Autowired
	VueloDAO vueloDao;
	
	// OBTENER LA LISTA DE VUELOS
	public List<Vuelo> obtenerVuelos() {
		return null;
	}
	
	// OBTENER LISTA DE VUELOS OPTIONAL
	public Optional<List<Vuelo>> ObtenerVuelosOptional() {
		return null;
	}

	// OBTENER UN VUELO A PARTIR DE SU ID
	public Vuelo obtenerVuelo(Long id) {
		return null;
	}
	
	// OBTENER UN VUELO OPTIONAL A PARTIR DE SU ID
	public Optional<Vuelo> obtenerVueloOptional(Long nro){
		return null;
	}

	// DAR DE ALTA O ACTUALIZAR UN VUELO
	public Vuelo guardarVuelo(Vuelo vuelo) {
		return null;
	}

	// ELIMINAR UN VUELO.
	public void eliminarVuelo(Vuelo vuelo) {
		
	}
}
