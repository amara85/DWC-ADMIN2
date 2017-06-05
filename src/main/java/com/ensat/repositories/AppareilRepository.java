package com.ensat.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ensat.entities.Appareil;

public interface AppareilRepository extends CrudRepository<Appareil, Integer> {

	Appareil findByCode(String code);
	
	@Override
    @Query
    public Iterable<Appareil> findAll();
	
	
}