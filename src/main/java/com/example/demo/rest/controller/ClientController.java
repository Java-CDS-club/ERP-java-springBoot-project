package com.example.demo.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Client;
import com.example.demo.service.ClientService;
import com.spark.formation.rest.dto.ClientDto;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClientController {



    @Autowired
    private ClientService clientService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/client")
    public Object clientsList() {
        List<Client> clients = clientService.getAllClient();
        Type listType = new TypeToken<List<ClientDto>>(){}.getType();
        List<ClientDto> clientDtos = modelMapper.map(clients, listType);
        return ResponseEntity.status(HttpStatus.OK).body(clientDtos);
    }

    @GetMapping("/client/{id}")
    public Object retrieveClient(@PathVariable long id) {
        Client client = clientService.getClient(id);
        ClientDto clientDto = modelMapper.map( client,  ClientDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(clientDto);
    }

    @PostMapping("/client")
    public Object addClient(@Valid @RequestBody ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);

        client = clientService.saveClient(client);

        clientDto = modelMapper.map(client, ClientDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDto);
    }

    @PutMapping("/client/{code_clt}")
    public Object updateClient(@Valid @RequestBody ClientDto clientDto, @PathVariable long code_clt) {
        Client client = modelMapper.map(clientDto, Client.class);
        client.setId(code_clt);

        client = clientService.saveClient(client);

        clientDto = modelMapper.map(client, ClientDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @DeleteMapping("/client/{id}")
    public Object Delete(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


  


}
