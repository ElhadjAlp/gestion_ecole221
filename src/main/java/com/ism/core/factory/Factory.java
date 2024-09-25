package com.ism.core.factory;

import com.ism.data.repository.MedecinRepository;
import com.ism.data.repository.RvRepository;
import com.ism.data.repository.bd.MedecinRepositoryBD;
import com.ism.data.repository.bd.RvRepositoryBD;

public class Factory {
    private Factory() {
       
    }

    private static MedecinRepository clientRepository = null;
    private static RvRepository rvRepository = null;

    public static MedecinRepository getInstanceClientRepository() {
        if (clientRepository == null) {
            clientRepository = new MedecinRepositoryBD(getInstanceRvRepository());
        }
        return clientRepository;
    }

    public static RvRepository getInstanceRvRepository() {
        if (rvRepository == null) {
            rvRepository = new RvRepositoryBD();
        }
        return rvRepository;
    }

    public static MedecinRepository getInstanceMedecinRepository() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInstanceMedecinRepository'");
    }
}

