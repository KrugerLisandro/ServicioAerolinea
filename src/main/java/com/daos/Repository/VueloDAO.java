package com.daos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daos.Entity.Vuelo;

public interface VueloDAO extends JpaRepository<Vuelo, Long>{

}
