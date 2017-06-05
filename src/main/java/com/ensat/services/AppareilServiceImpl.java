package com.ensat.services;

import com.ensat.entities.Appareil;
import com.ensat.repositories.AppareilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Appareil service implement.
 */
@Service
public class AppareilServiceImpl implements AppareilService {

	@Autowired
    private AppareilRepository AppareilRepository;
	
    public void setAppareilRepository(AppareilRepository AppareilRepository) {
        this.AppareilRepository = AppareilRepository;
    }
    
	public Iterable<Appareil> listAllAppareils() {
        return AppareilRepository.findAll();
    }

    public Appareil saveAppareil(Appareil Appareil) {
        return AppareilRepository.save(Appareil);
    }
    
    public void deleteAppareil(Appareil Appareil) {
        AppareilRepository.delete(Appareil);
    }

	@Override
	public Appareil findByCode(String code) {
		return AppareilRepository.findByCode(code);
	}
    
	@Override
	public Appareil findById(int id) {
		return AppareilRepository.findOne(id);
	}
    

}
