package com.usa.misiontic23.masterclass3.repository.crudRepository;



import com.usa.misiontic23.masterclass3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
