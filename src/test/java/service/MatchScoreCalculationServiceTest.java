package service;

import com.bma.model.MatchScore;
import com.bma.service.MatchScoreCalculationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatchScoreCalculationServiceTest {
    private  MatchScoreCalculationService matchScoreCalculationService;
    private   MatchScore matchScore;

    @BeforeEach
    public  void InitSources() {
        matchScoreCalculationService = MatchScoreCalculationService.getInstance();
        matchScore = new MatchScore();
    }

    @Test
    @DisplayName("First test!")
    public void scoreAdvantage(){
        matchScore.setFirstPlayerScore(40);
        matchScore.setSecondPlayerScore(40);

//        matchScoreCalculationService.winsGoal("firstPlayerGotGoal", null, matchScore);
    }

}
