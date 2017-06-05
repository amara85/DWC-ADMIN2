package com.ensat.services;

import com.ensat.entities.Appareil;

public interface AppareilService {

    Iterable<Appareil> listAllAppareils();

    Appareil saveAppareil(Appareil Appareil);

    void deleteAppareil(Appareil Appareil);
    
    Appareil findByCode(String code);

	Appareil findById(int id);

}
