package com.github.phillipkruger.user.backend;

import com.github.phillipkruger.user.model.Score;
import com.github.phillipkruger.user.model.ScoreType;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.extern.java.Log;

@Log
@ApplicationScoped
public class ScoreDB {

    @Inject
    Map<String,List<Score>> scoreDatabase;
    
    public List<Score> getScores(String idNumber){
        log.log(Level.SEVERE, "======= Getting scores [{0}] =======", idNumber);
        return scoreDatabase.get(idNumber);
    }
    
    public Score getScore(ScoreType type,String idNumber){
        List<Score> scores = getScores(idNumber);
        for(Score score:scores){
            if(score.getName().equals(type))return score;
        }
        return null;
    }
}