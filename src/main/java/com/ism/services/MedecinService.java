package com.ism.services;

import java.util.List;

import com.ism.data.entites.Medecin;

public interface MedecinService {
    void createMedecin(Medecin medecin);

    List<Medecin> findAllMedecins();

    Medecin searchMedecin(String telephone);

    Medecin searchMedecinByDate(String surname);
}
