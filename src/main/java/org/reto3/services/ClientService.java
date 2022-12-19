package org.reto3.services;

import org.reto3.entities.Client;
import org.reto3.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    //Attributes
    @Autowired
    private ClientRepository clientRepository;


    //CRUD Methods
    public List<Client> getAllClients() {
        System.out.println("EveryTh ok 'til Here");
        return this.clientRepository.findAll();
    }

    public Client getClientById(int id) {
        if(this.clientRepository.findById(id).isPresent()){
            return this.clientRepository.findById(id).get();
        }else{
            return null;
        }
    }

    public Client createClient(Client client) {
        return this.clientRepository.save(client);
    }

    public void updateClient(Integer idClient, Client capturedData) {
        Optional<Client> clientToUpdate =  this.clientRepository.findById(idClient);
        if(!clientToUpdate.isEmpty()){
            Client clientDB =  clientToUpdate.get();
            setAllAtts(clientDB, capturedData);
            this.clientRepository.save(clientDB);
        }
    }

    private void setAllAtts(Client clToUpdate, Client newData){
        if(newData.getName() != null)       clToUpdate.setName(newData.getName());
        if(newData.getEmail() != null)        clToUpdate.setEmail(newData.getEmail());
        if(newData.getPassword() != null) clToUpdate.setPassword(newData.getPassword());
        if(newData.getAge() != null)           clToUpdate.setAge(newData.getAge());
    }

    public void deleteClient(int id) {
        if(!this.clientRepository.findById(id).isEmpty())  this.clientRepository.deleteById(id);
    }


}
