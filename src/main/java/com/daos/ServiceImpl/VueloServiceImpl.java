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
	private Validator validator;
	
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
	
	// OBTENER UN VUELO OPTIONAL A PARTIR DE SU ID.
	public Optional<Vuelo> obtenerVueloOptional(Long nro){
		return vueloDao.findById(nro);
	}

	// DAR DE ALTA UN VUELO.
	public Vuelo guardarVuelo(Vuelo vuelo) throws Excepcion {
		
		Set<ConstraintViolation<Vuelo>> constraintViolation = validator.validate(vuelo);
		if(constraintViolation.size()>0)
		{
			String errors="";
			for (ConstraintViolation<Vuelo> cv : constraintViolation) {
				errors+= cv.getPropertyPath() + ": " + cv.getMessage() + "\n";
			}
			// BAB_REQUEST
			throw new Excepcion(400, errors);
		}
		
		// VALIDAR SI EXISTE UN NRO DE VUELO REGISTRADO.
		if (existeNroVuelo(vuelo.getNro())) {
			throw new Excepcion("YA EXISTE UN NRO DE VUELO REGISTRADO.");
		}
		
		return vueloDao.save(vuelo);
	}
	
	// ACTUALIZAR O ELIMINAR UN VUELO.
	public Vuelo actualizarVuelo(Vuelo vuelo) throws Excepcion{
	
		return vueloDao.save(vuelo);
	}
	
	/**
	 * @return DEVUELVE TRUE SI YA EXISTE UN NRO DE VUELO.
	 *         SINO RETORNA FALSE.
	 */
	private boolean existeNroVuelo(Long nro) {

		boolean band = false;
		Long dniEmpleado = vueloDao.findByNroVuelo(nro);

		if (dniEmpleado != null)
			band = true;

		return band;
	}
}
