package com.usa.misiontic23.masterclass3.repository;

import com.usa.misiontic23.masterclass3.entities.Box;
import com.usa.misiontic23.masterclass3.entities.Category;
import com.usa.misiontic23.masterclass3.repository.crudRepository.BoxCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class BoxRepository {

    @Autowired
    private BoxCrudRepository boxCrudRepository;
    public List<Box> getALL(){
        return (List<Box>) boxCrudRepository.findAll();

    }
    public Optional<Box> getById(int id){
        return boxCrudRepository.findById(id);
    }
    public Box save(Box c){
        return boxCrudRepository.save(c);
    }
    public void delete(Box c){
        boxCrudRepository.delete(c);
    }
}
