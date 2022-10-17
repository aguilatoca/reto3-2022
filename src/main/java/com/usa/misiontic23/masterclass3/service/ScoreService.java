package com.usa.misiontic23.masterclass3.service;


import com.usa.misiontic23.masterclass3.entities.Score;
import com.usa.misiontic23.masterclass3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getALL(){
        return scoreRepository.getALL();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getById(id);
    }
    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> e = scoreRepository.getById(score.getIdScore());
            if (e.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }

}