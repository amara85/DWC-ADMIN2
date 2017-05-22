package com.ensat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.repositories.DimtempsRepository;

/**
 * Role service implement.
 */
@Service("dimtempsService")
public class DimtempsServiceImpl implements DimtempsService  {

	@Autowired
    private DimtempsRepository dimtempsRepository;
    
    public void setDimtempsRepository(DimtempsRepository dimtempsRepository) {
		this.dimtempsRepository = dimtempsRepository;
	}


	public List<Integer> returnDistinctAnnee(){
		return dimtempsRepository.returnDistinctAnnee();
    }
    
    

}
