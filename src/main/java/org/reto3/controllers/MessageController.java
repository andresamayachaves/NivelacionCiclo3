package org.reto3.controllers;

import org.reto3.entities.Message;
import org.reto3.entities.Message;
import org.reto3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@RestController
@RequestMapping("/api/Message")
public class MessageController {

    //Attributes
    @Autowired
    MessageService messageService;

    //Constructor
    public MessageController(MessageService messageService) {
            this.messageService = messageService;
    }


    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
        return new ResponseEntity<List<Message>>(this.messageService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Message> getMessageById(@PathVariable("id") int id) {
        return new ResponseEntity<Message>(this.messageService.getMessageById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Message>> createMessage(@RequestBody Message message){
        Message fullMessage =  messageService.addNextIdToMessage(message);
        this.messageService.createMessage(fullMessage);
        return new ResponseEntity<List<Message>>(this.messageService.getAllMessages(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<List<Message>> updateMessage(@RequestBody Message message){
        this.messageService.updateMessage(message.getIdMessage(), message);
        return new ResponseEntity<List<Message>>(messageService.getAllMessages(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable("id") int id){
        this.messageService.deleteMessage(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
