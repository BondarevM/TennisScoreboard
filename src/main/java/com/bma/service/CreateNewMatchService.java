package com.bma.service;

import com.bma.dao.PlayerDao;
import com.bma.exception.DatabaseException;
import com.bma.exception.PlayerNameException;
import com.bma.model.Match;
import com.bma.model.MatchScore;
import com.bma.model.Player;

import java.util.UUID;

public class CreateNewMatchService {
    private static final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
    private static final PlayerDao playerDao = PlayerDao.getInstance();

    public Player saveOrGetPlayer(String playerName) {
        Player player = null;

        try {
           playerDao.save(playerName);
           player = playerDao.findByName(playerName);
        } catch (DatabaseException e) {
            player = playerDao.findByName(playerName);
        }

        return player;
    }


    public String createNewMatch(String firstPlayerName, String secondPlayerName) throws PlayerNameException {
        String[] validatedPlayerNames = validatePlayerNames(firstPlayerName, secondPlayerName);

        Player firstPlayer = saveOrGetPlayer(validatedPlayerNames[0]);
        Player secondPlayer = saveOrGetPlayer(validatedPlayerNames[1]);

        Match newMatch = Match.builder()
                .player1(firstPlayer)
                .player2(secondPlayer)
                .matchScore(new MatchScore(0, 0, 0, 0, 0,
                        0, false, false, false, false, false))
                .isSaved(false)
                .build();

        String uuid = UUID.randomUUID().toString();

        return ongoingMatchesService.putNewMatch(uuid, newMatch);

    }

    private String[] validatePlayerNames(String firstPlayerName, String secondPlayerName) throws PlayerNameException {
        if (firstPlayerName.isEmpty() || secondPlayerName.isEmpty()){
            throw new PlayerNameException("Write the names of the players");        }


        if (firstPlayerName.equals(secondPlayerName)){
            throw new PlayerNameException("Write the names of two different players");
        }
        String f1 = firstPlayerName.substring(0,1).toUpperCase() + firstPlayerName.substring(1).toLowerCase();
        String f2 = secondPlayerName.substring(0,1).toUpperCase() + secondPlayerName.substring(1).toLowerCase();
        return new String[]{f1,f2};
    }


    public static CreateNewMatchService getInstance() {
        return INSTANCE;
    }

    private CreateNewMatchService() {
    }

    private static final CreateNewMatchService INSTANCE = new CreateNewMatchService();
}
