package com.ism.repository.List;

import java.util.ArrayList;
import java.util.List;

import com.ism.entites.Client;

public class ClientRepository {
    private static final List<Client> List = null;
    private List<Client> clientList = new ArrayList<>();

    public void insert(Client client) {
        clientList.add(client);
    }

    public List<Client> selectAll() {
        return List;
    }

    public Client selectByPhone(String phone) {
        return clientList.stream().filter(client -> client.getPhone().compareTo(phone) == 0).findFirst().orElse(null);
    }
}
