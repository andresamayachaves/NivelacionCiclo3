package org.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.reto3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idMessage;

    @Column(name = "messageText")
    private String messageText;

    //Relationships

//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties(value = {"messages", "reservations"})
//    @JoinColumn(name = "client_id")
    @ManyToOne(fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
    @JoinColumn(name = "client_id_client")
    private Client client;

//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JsonIgnoreProperties(value = {"messages", "reservations"})
//    @JoinColumn(name = "farm_id")
    @ManyToOne(fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
    @JoinColumn(name = "farm_id")
    private Farm farm;


    //Constructor No-args
    public Message() {
    }

    //Constructor
    public Message(Integer idMessage, Farm farm, String messageText) {
        this.idMessage = idMessage;
        this.farm = farm;
        this.messageText = messageText;
    }


    //Getters and setters

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

   //public void printAllAtts(){MessageService.printAllAtts(this);}

}
