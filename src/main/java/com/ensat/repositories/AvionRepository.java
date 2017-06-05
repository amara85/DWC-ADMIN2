package com.ensat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ensat.entities.Avion;

public interface AvionRepository extends CrudRepository<Avion, Integer> {

	Avion findByImm(String imm);
	
	Iterable<Avion> findByAppareil(String appareil);
	
	@Override
    @Query
    public Iterable<Avion> findAll();
	
	
}