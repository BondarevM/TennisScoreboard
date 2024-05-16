package service;

import com.bma.model.Match;
import com.bma.model.MatchScore;
import com.bma.service.MatchScoreCalculationService;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class MatchScoreCalculationServiceTest {
    private MatchScoreCalculationService matchScoreCalculationService;
    private Match match;

    @BeforeEach
    public void InitSources() {
        matchScoreCalculationService = MatchScoreCalculationService.getInstance();
        match = Match.builder()
                .matchScore(new MatchScore(0, 0, 0, 0, 0, 0,
                        false, false, false, false, false))
                .build();
    }

    @Test
    public void IfPlayerWinsPointWhenScore40_40GameDoesNotEnd() {
        match.getMatchScore().setFirstPlayerScore(40);
        match.getMatchScore().setSecondPlayerScore(40);
        match.getMatchScore().setFirstPlayerGame(0);
        match.getMatchScore().setSecondPlayerGame(0);

        matchScoreCalculationService.winsGoal("first", null, match);

        assertEquals(0, match.getMatchScore().getFirstPlayerGame());
        assertEquals(0, match.getMatchScore().getSecondPlayerGame());

    }

    @Test
    public void IfPlayerWinsPointWhenScore40_0GameEnds() {
        match.getMatchScore().setFirstPlayerScore(40);
        match.getMatchScore().setSecondPlayerScore(0);
        match.getMatchScore().setFirstPlayerGame(0);
        match.getMatchScore().setSecondPlayerGame(0);

        matchScoreCalculationService.winsGoal("first", null, match);

        assertEquals(match.getMatchScore().getFirstPlayerGame(), 1);
        assertEquals(match.getMatchScore().getSecondPlayerGame(), 0);

    }

    @Test
    public void WhenScore6_6TiebreakBegins() {
        match.getMatchScore().setFirstPlayerScore(40);
        match.getMatchScore().setSecondPlayerScore(0);
        match.getMatchScore().setFirstPlayerGame(5);
        match.getMatchScore().setSecondPlayerGame(6);

        matchScoreCalculationService.winsGoal("first", null, match);

        assertTrue(match.getMatchScore().isTieBreak());

    }

}
