package com.familyapp.message;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {

    private MessageRepository messages;

    public MessageService(MessageRepository mr) {
        super();
        this.messages = mr;
    }

    @Override
    public Message findById(long id){
        try {
            return this.messages.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Message> findAll(){
        return this.messages.findAll();
    }

    @Override
    public boolean delete(long id){
        Message m = this.findById(id);
        try {
            this.messages.delete(m);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Message create(Message m){
        m = this.messages.save(m);
        return m;
    }

    

    @Override
    public Message update(long id, Message formData){
        Message oldMessage = this.findById(id);
        if(oldMessage == null){
            return null;
        }
        if (formData.getSubject() != null) {
            oldMessage.setSubject(formData.getSubject());  
        }else{
            oldMessage.setSubject(oldMessage.getSubject());
        }
        if (formData.getPinned() != null) {
            oldMessage.setPinned(formData.getPinned());  
        }else{
            oldMessage.setPinned(oldMessage.getPinned());
        }
        if (formData.getDate() != null) {
            oldMessage.setDate(formData.getDate());  
        }else{
            oldMessage.setDate(oldMessage.getDate());
        }
        
       

        return this.messages.save(oldMessage);
    }


}
    

