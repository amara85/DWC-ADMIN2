package com.ensat.repositories;

import com.ensat.entities.Dimtemps;
import org.springframework.data.repository.CrudRepository;

public interface DimtempsRepository extends CrudRepository<Dimtemps, Integer>, DimtempsRepositoryCustom {
	
}