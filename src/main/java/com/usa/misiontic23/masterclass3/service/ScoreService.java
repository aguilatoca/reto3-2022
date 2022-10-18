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
        return scoreRepository.getScore(id);
    }
    public Score save(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> e = scoreRepository.getScore(score.getIdScore());
            if (e.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }

    public Score update (Score score){
        if(score.getIdScore()!=null){
            Optional<Score> e = getScore(score.getIdScore());
            if(!e.isEmpty()){
                if(Score.setMessageText()!=null){
                    e.get().setMessageText(score.setMessageText());
                }
                if(score.getScore()!=null){
                    e.get().setScore(score.getScore());
                }
                return scoreRepository.save(e.get());
            }
        }
        return score;
    }

    public boolean delete(int id){
        Boolean respuesta = getScore(id).map(elemento ->{
            scoreRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }

}