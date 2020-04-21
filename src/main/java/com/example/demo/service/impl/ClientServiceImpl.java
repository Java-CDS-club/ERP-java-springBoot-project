package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import com.spark.formation.exception.ClientNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClient(Long id) {
        Client client= clientRepository.findById(id).get();

        if(client == null) {
            throw new ClientNotFoundException();
        }
        return client;
    }



    @Override
    public List<Client> getAllClient() {
        return (List<Client>) clientRepository.findAll();

    }

    @Override
    @Transactional
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ClientNotFoundException();
        }
    }

   


    @Override
    @Transactional
    public Client updateClientname(long id, String name) {
        Client client = getClient(id);
        client.setName(name);
        return saveClient(client);
    }
}
