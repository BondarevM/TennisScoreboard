package com.bma.service;

import com.bma.dao.MatchDao;
import com.bma.exception.PaginationException;
import com.bma.model.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchesService {
    private static final MatchDao matchDao = MatchDao.getInstance();

    public List<Match> getFiveMatches(int pageNumber, String playerName) throws PaginationException {
        pageNumber -= 1;
        List<Match> allMatches = matchDao.findAll();
        List<Match> fiveMatches = new ArrayList<>();

        allMatches = selectMatchesWithPlayerName(playerName, allMatches);

        try {
            if (allMatches.size() < pageNumber * 5 + 5) {
                return allMatches.subList(pageNumber * 5, allMatches.size());
            }

            for (int i = 0; i < 5; i++) {
                fiveMatches.add(allMatches.get(pageNumber * 5 + i));
            }
            return fiveMatches;
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new PaginationException("Incorrect page number");
        }
    }

    public boolean checkEndOfData(int pageNumber, String playerName) {
        List<Match> allMatches = matchDao.findAll();
        allMatches = selectMatchesWithPlayerName(playerName, allMatches);

        if (allMatches.size() >= (pageNumber - 1) * 5 && allMatches.size() <= pageNumber * 5) {
            return true;
        } else {
            return false;
        }
    }

    private List<Match> selectMatchesWithPlayerName(String playerName, List<Match> allMatches) {
        if (playerName != null) {
            if (!playerName.isEmpty()) {
                List<Match> newAllMatches = new ArrayList<>();
                for (Match match : allMatches) {
                    if (match.getPlayer1().getName().equals(playerName) || match.getPlayer2().getName().equals(playerName)) {
                        newAllMatches.add(match);
                    }
                }
                allMatches = newAllMatches;
            }
        }
        return allMatches;
    }


    private static final MatchesService INSTANCE = new MatchesService();

    private MatchesService() {
    }

    public static MatchesService getInstance() {
        return INSTANCE;
    }
}
