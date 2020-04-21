package com.example.demo.service;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.entity.Client;

@CrossOrigin(origins = "http://localhost:4200")
public interface ClientService {

    Client getClient(Long id);

    List<Client> getAllClient();

    Client saveClient(Client client);

    Client updateClientname(long id, String name);


   /* String getClientByRef_clt(Long id);*/

    void deleteClient(Long id);


}
