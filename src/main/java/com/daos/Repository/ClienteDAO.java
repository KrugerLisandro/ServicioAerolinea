package com.daos.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daos.Entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{	

	@Query(value = "SELECT v.dni FROM cliente v WHERE v.dni = ?1", nativeQuery = true)
	Long findBydni (Long dni);	

}
