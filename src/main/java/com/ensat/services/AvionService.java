package com.ensat.services;

import com.ensat.entities.Appareil;
import com.ensat.entities.Avion;

public interface AvionService {

    Iterable<Avion> listAllAvions();

    Avion saveAvion(Avion avion);

    void deleteAvion(Avion avion);
    
    Avion findByImm(String imm);
    
    Iterable<Avion> findByAppareil(String appareil);

	void updateAvions(Iterable<Avion> avions, Appareil appareil);

}
