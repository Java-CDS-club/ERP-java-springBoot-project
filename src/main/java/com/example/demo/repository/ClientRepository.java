package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.entity.Client;

@CrossOrigin(origins = "http://localhost:4200")
public interface ClientRepository extends CrudRepository<Client ,Long>
{
   /* Client findClientByRef_clt(String ref_clt);*/
}
