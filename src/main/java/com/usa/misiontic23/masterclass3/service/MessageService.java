package com.usa.misiontic23.masterclass3.service;

import com.usa.misiontic23.masterclass3.entities.Category;
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

    public static List<Message> getALL(){
        return messageRepository.getALL();
    }
    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }
    public Message save(Message p){
        if(p.getIdMessage()==null){
            return messageRepository.save(p);
        }else{
            Optional<Message> e = messageRepository.getMessage(p.getIdMessage());
            if (e.isPresent()){
                return p;
            }else{
                return messageRepository.save(p);
            }
        }
    }

    public Message update(Message p)
    {
        if (p.getIdMessage()!=null)
        {
            Optional<Message> q = messageRepository.getMessage(p.getIdMessage());
            if(q.isPresent())
            {
                if (p.getMessage() != null)
                {
                    q.get().setMessage(p.getMessage());
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
        Optional<Message>p= messageRepository.getMessage(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }
}
