package com.ism.services;

import java.util.List;

import com.ism.data.entites.Medecin;
import com.ism.data.entites.Rv;

public interface RvService {

    public void createRv(Rv rv) ;
    public List<Medecin> findAllRv();
    public List<Medecin> findAllMedecins();
}
