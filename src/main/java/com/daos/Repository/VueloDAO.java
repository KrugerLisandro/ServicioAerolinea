package com.daos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daos.Entity.Vuelo;

public interface VueloDAO extends JpaRepository<Vuelo, Long>{
	
	/*
	 * CONSULTA SQL PARA VERIFICAR SI YA EXISTE UN NRO DE VUELO REGISTRADO.
	 */
	@Query(value = "SELECT v.nro FROM vuelo v WHERE v.nro = ?1", nativeQuery = true)
	Long findByNroVuelo(Long nro);
	
	@Query(value = "SELECT v FROM vuelo v WHERE v.estado = ?1", nativeQuery = true)
	public List<Vuelo>findByEstado(String estado);
	
	
}
