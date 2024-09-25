package com.ism.data.repository;

import com.ism.core.Repository.Repository;
import com.ism.data.entites.Medecin;


public interface MedecinRepository  extends Repository<Medecin>{
    Medecin selectByDate(String telephone);
    Medecin selectByNom(String surname);
}
