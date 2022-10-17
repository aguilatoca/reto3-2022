package com.usa.misiontic23.masterclass3.repository;



import com.usa.misiontic23.masterclass3.entities.Message;
import com.usa.misiontic23.masterclass3.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCuedRepository;

    public List<Message> getALL()
    {
        return (List<Message>) messageCuedRepository.findAll();
    }
    public Optional<Message> getById(int id)
    {
        return messageCuedRepository.findById(id);

    }
    public Message save(Message p)
    {
        return messageCuedRepository.save(p);

    }

    public void delete(Message p)
    {
        messageCuedRepository.delete(p);
        
    }
}

