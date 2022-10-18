package com.usa.misiontic23.masterclass3.service;


import com.usa.misiontic23.masterclass3.entities.Message;
import com.usa.misiontic23.masterclass3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getALL(){
        return messageRepository.getALL();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message p){
        if(p.getMessageText() == null){
            return messageRepository.save(p);
        }else{
            Optional<Message> e = getMessage(p.getIdMessage());
            if (e.isEmpty()){
                return messageRepository.save(p);
            }else{
                return p;
            }
        }
    }

    public Message update(Message p)
    {
        if (p.getMessageText()!=null)
        {
            Optional<Message> q = getMessage(p.getIdMessage());
            if(q.isPresent())
            {
                if (p.getMessageText() != null)
                {
                    q.get().setMessageText(p.getMessageText());
                }

                return messageRepository.save(q.get());

             }

        }
            return p;

    }

    public boolean delete(int id){
        boolean respuesta = getMessage(id).map(elemento ->{
           messageRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}