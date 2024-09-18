package com.ism.services.Implemente;

import java.util.List;

import com.ism.entites.Client;
import com.ism.repository.List.ClientRepository;

public class ClientServiceImpl {
    private ClientRepository clientRepository = new ClientRepository();

    public void create(Client client) {
        clientRepository.insert(client);
    }

    public List<Client> findAll() {
        return clientRepository.selectAll();
    }

    public Client findByPhone(String telephone) {
       return clientRepository.selectByPhone(telephone);
    }

}
