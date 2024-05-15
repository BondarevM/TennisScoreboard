package com.bma.service;

import com.bma.dao.PlayerDao;
import com.bma.model.Match;
import com.bma.model.MatchScore;
import com.bma.model.Player;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CreateNewMatchService {
    private static final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
    private static final PlayerDao playerDao = PlayerDao.getInstance();

    public static void main(String[] args) {
        INSTANCE.createNewMatch("Bob", "Tom");
    }

    public Player validatePlayer(String playerName) {
        Player player = playerDao.findByName(playerName);

        if (player == null) {
            playerDao.save(playerName);
            player = playerDao.findByName(playerName);
        }

        return player;
    }


    public String createNewMatch(String firstPlayerName, String secondPlayerName) {
        Player firstPlayer = validatePlayer(firstPlayerName);
        Player secondPlayer = validatePlayer(secondPlayerName);

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


    public static CreateNewMatchService getInstance() {
        return INSTANCE;
    }

    private CreateNewMatchService() {
    }

    private static final CreateNewMatchService INSTANCE = new CreateNewMatchService();
}
