package com.ensat.services;

import com.ensat.entities.Appareil;
import com.ensat.entities.Avion;
import com.ensat.repositories.AvionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Avion service implement.
 */
@Service
public class AvionServiceImpl implements AvionService {

	@Autowired
    private AvionRepository avionRepository;
	
    public void setAvionRepository(AvionRepository AvionRepository) {
        this.avionRepository = AvionRepository;
    }
    
	public Iterable<Avion> listAllAvions() {
        return avionRepository.findAll();
    }

    public Avion saveAvion(Avion avion) {
        return avionRepository.save(avion);
    }
    
    public void deleteAvion(Avion avion) {
        avionRepository.delete(avion);
    }

	@Override
	public Avion findByImm(String imm) {
		return avionRepository.findByImm(imm);
	}
    
	@Override
	public Iterable<Avion> findByAppareil(String appareil) {
		return avionRepository.findByAppareil(appareil);
	}

	@Override
	public void updateAvions(Iterable<Avion> avions, Appareil appareil) {
		for(Avion avion : avions){
			avion.setAppareil(appareil.getCode());
			avion.setTuaff(appareil.getTuaff());
	    	avion.setType(appareil.getType());
	    	avion.setCapacite(appareil.getSo());
	    	avionRepository.save(avion);
		}
		
	}
    

}
