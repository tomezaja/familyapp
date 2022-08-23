package com.familyapp.message;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private IMessageService messageService;

    public MessageController(IMessageService ms) {
            super();
            this.messageService = ms;
    }

    @GetMapping("/api/messages")
    public List<Message> findAll() {
        List<Message> messages = this.messageService.findAll();
        return messages;
    }

    @GetMapping("/api/messages/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Message message = this.messageService.findById(id);
        if(message == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Message not found");
        }
        return ResponseEntity.ok(message);

    }

    @DeleteMapping("/api/messages/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean success = this.messageService.delete(id);
        if(!success) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Message not found");
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/messages")
    public ResponseEntity<?> create(@RequestBody Message messages){
        Message newMessage = this.messageService.create(messages);
        return ResponseEntity.ok(newMessage);
    }
  
    @PutMapping("/api/messages/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Message formData) {
        Message updatedMessage = this.messageService.update(id, formData);
        if(updatedMessage == null){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Message not found");
        }
        return ResponseEntity.ok(updatedMessage);
    }
}