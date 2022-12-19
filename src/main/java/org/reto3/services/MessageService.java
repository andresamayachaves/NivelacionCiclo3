package org.reto3.services;

import org.reto3.entities.Client;
import org.reto3.entities.Farm;
import org.reto3.entities.Message;
import org.reto3.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    //Attributes
    @Autowired
    private  MessageRepository messageRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private FarmService farmService;

    //Constructor
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    //CRUD Methods
    public List<Message> getAllMessages(){
        return this.messageRepository.findAll();
    }

    public Message getMessageById(int id) {
        Optional<Message> selectedMessage = this.messageRepository.findById(id);
        if(selectedMessage.isPresent()){
            return selectedMessage.get();
        }else{return null;  }
    }

    public Message createMessage(Message newMessage) {
        return this.messageRepository.save(newMessage);}

    public void updateMessage (int idMessage, Message capturedMessage){
        Optional<Message> messageToUpdate = this.messageRepository.findById(idMessage);
        if(messageToUpdate.isPresent()){
                Message messageDB = messageToUpdate.get();
                setAllAtts(messageDB, capturedMessage);
                this.messageRepository.save(messageDB);
        }
    }

    private void setAllAtts(Message msgToUpdate, Message newData){
        if(newData.getIdMessage() != null)       msgToUpdate.setIdMessage(newData.getIdMessage());
        if(newData.getMessageText() != null)        msgToUpdate.setMessageText(newData.getMessageText());
        if(newData.getClient() != null)        msgToUpdate.setClient(newData.getClient());
        if(newData.getFarm()  != null)        msgToUpdate.setFarm(newData.getFarm());
    }

    public void deleteMessage(int id) {
       Optional toDelete = this.messageRepository.findById(id);
        if(!toDelete.isEmpty()){
            this.messageRepository.delete((Message) toDelete.get());
        }
    }
    public Message addNextIdToMessage(Message messageIn) {

        Message messageOut = new Message();
        Integer newId = Integer.valueOf( String.valueOf(messageRepository.count()))+1;

        messageOut.setIdMessage(newId);
        messageOut.setMessageText(messageIn.getMessageText());
        messageOut.setClient(messageIn.getClient());
        messageOut.setFarm(messageIn.getFarm());

        printAllAtts(messageOut);
        return  messageOut;
    }

    public static void printAllAtts(Message msgToPrint) {
        System.out.println(msgToPrint.getIdMessage());
        System.out.println(msgToPrint.getMessageText());
        System.out.println(msgToPrint.getClient().getIdClient().toString());
        System.out.println(msgToPrint.getFarm().getId().toString());
    }
}
