package com.usa.misiontic23.masterclass3.repository;


import com.usa.misiontic23.masterclass3.entities.Score;
import com.usa.misiontic23.masterclass3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    //public static List<Score> getAll;
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    public List<Score> getALL(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score c){
        return scoreCrudRepository.save(c);
    }
    public void delete(Score c){
        scoreCrudRepository.delete(c);
    }

}
