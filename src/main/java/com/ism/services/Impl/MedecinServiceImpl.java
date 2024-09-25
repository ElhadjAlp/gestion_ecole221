package com.ism.services.Impl;

import java.util.List;

import com.ism.data.entites.Medecin;
import com.ism.data.repository.MedecinRepository;
import com.ism.services.MedecinService;

public class MedecinServiceImpl implements MedecinService {
    private MedecinRepository medecinRepository;

    public MedecinServiceImpl(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    public void createMedecin(Medecin medecin) {
        medecinRepository.insert(medecin);
    }

    @Override
    public List<Medecin> findAllMedecins() {
        return medecinRepository.selectAll();
    }

    @Override
    public Medecin searchMedecin(String date) {
        return medecinRepository.selectByDate(date);
    }

    @Override
    public Medecin searchMedecinByDate(String surname) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchMedecinByDate'");
    }

    
    // public Medecin searchMedecinByNom(String nom) {
    //     return medecinRepository.selectByNom(nom);
    }

   
  

    


