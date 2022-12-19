package org.reto3.controllers;

import org.reto3.entities.Client;
import org.reto3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Client")
public class ClientController {

    //Attributes
    @Autowired
    ClientService clientService;

    //Constructor
    public ClientController(ClientService clientService) {this.clientService = clientService;}

    //CRUD Methods
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<List<Client>>(this.clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Client>  getClientById(@PathVariable("id") int id) {
        return new ResponseEntity<Client>((Client) this.clientService.getClientById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Client>>createClient(@RequestBody Client client){
        this.clientService.createClient(client);
        return new ResponseEntity<List<Client>>(this.clientService.getAllClients(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateClient(@RequestBody Client client){
        this.clientService.updateClient(client.getIdClient(), client);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") int id){
        this.clientService.deleteClient(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

