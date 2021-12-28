package br.com.zup.service;

import br.com.zup.model.Client;
import br.com.zup.repository.ClientRepository;

public class ClientService {

    public void saveClient(Client client){
    validateClient(client);
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.persist(client);
    }

    public void validateClient(Client client){


    }
}
