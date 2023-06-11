package com.daos.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daos.Entity.Vuelo;
import com.daos.Repository.VueloDAO;
import com.daos.Service.VueloService;
import com.daos.Exception.Excepcion;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class VueloServiceImpl implements VueloService {
	
	@Autowired
	private VueloDAO vueloDao;
	
	// OBTENER LA LISTA DE VUELOS.
	public List<Vuelo> obtenerVuelos() {
		return vueloDao.findAll();
	}
	
	// OBTENER LA LISTA POR ESTADO
	public List<Vuelo> filtroEstado(String estado) {
		
		return vueloDao.findByEstado(estado);
	}
	
	//OBTENER EL ESTADO DE UN VUELO A PARTIR DE SU ID
	public String findByVueloEstado(Long nro) {
		
		return vueloDao.findByVueloEstado(nro);
	}
	
	// OBTENER UN VUELO OPTIONAL A PARTIR DE SU ID.
	public Optional<Vuelo> obtenerVueloOptional(Long nro){
		return vueloDao.findById(nro);
	}

	// DAR DE ALTA UN VUELO.
	public Vuelo guardarVuelo(Vuelo vuelo){
		
		return vueloDao.save(vuelo);
	}
	
	// ACTUALIZAR O ELIMINAR UN VUELO.
	public Vuelo actualizarVuelo(Vuelo vuelo) throws Excepcion{
		
		if(findByVueloEstado(vuelo.getNro()).equals("cancelado")) {
			throw new Excepcion("NO SE PUEDE ACTUALIZAR, PORQUE EL VUELO FUE CANCELADO.");
		}
		
		return vueloDao.save(vuelo);
	}
}
