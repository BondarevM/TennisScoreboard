package com.bma.service;

import com.bma.dao.MatchDao;
import com.bma.model.Match;
import com.bma.model.Player;

public class FinishedMatchesPersistenceService {

    private static final CreateNewMatchService createNewMatchService = CreateNewMatchService.getInstance();
    private static final MatchDao matchDao = MatchDao.getInstance();

    public void saveMatch(Match currentMatch){
//
//        Player firstPlayer = createNewMatchService.validatePlayer(firstPlayerName);
//        Player secondPlayer = createNewMatchService.validatePlayer(secondPlayerName);
//        Player winner = createNewMatchService.validatePlayer(winnerName);

        Match match = Match.builder()
                .player1(currentMatch.getPlayer1())
                .player2(currentMatch.getPlayer2())
                .winner(currentMatch.getWinner())
                .build();

        matchDao.save(match);
    }



    private FinishedMatchesPersistenceService(){}
    private static final FinishedMatchesPersistenceService INSTANCE = new FinishedMatchesPersistenceService();
    public static FinishedMatchesPersistenceService getInstance(){return INSTANCE;}

}
