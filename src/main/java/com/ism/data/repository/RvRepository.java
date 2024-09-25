package com.ism.data.repository;

import com.ism.core.Repository.Repository;
import com.ism.data.entites.Medecin;

public interface RvRepository extends Repository<Medecin> {
    Medecin selectByLogin(String login);
    Medecin selectByID(int id);
}