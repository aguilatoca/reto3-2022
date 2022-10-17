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
        return messageRepository.getById(id);
    }
    public Message save(Message p){
        if(p.getMessageText() == null){
            return messageRepository.save(p);
        }else{
            Optional<Message> e = messageRepository.getById(p.getIdMessage());
            if (e.isPresent()){
                return p;
            }else{
                return messageRepository.save(p);
            }
        }
    }

    public Message update(Message p)
    {
        if (p.getMessageText()!=null)
        {
            Optional<Message> q = messageRepository.getById(p.getIdMessage());
            if(q.isPresent())
            {
                if (p.getMessageText() != null)
                {
                    q.get().setIdMessage(p.getIdMessage());
                }

                messageRepository.save(q.get());
                return q.get();

            } else
            {
                return p;
            }
        }else {
            return p;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Message>p= messageRepository.getById(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}