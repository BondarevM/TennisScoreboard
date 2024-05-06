package com.bma.service;

import com.bma.dao.MatchDao;
import com.bma.exception.CustomException;
import com.bma.model.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchesService {
    private static final MatchDao matchDao = MatchDao.getInstance();

    public List<Match> findAll(int pageNumber) throws CustomException {
        pageNumber -= 1;
        List<Match> allMatches = matchDao.findAll();
        List<Match> fiveMatches = new ArrayList<>();

        try {
            if (allMatches.size() < pageNumber * 5 + 5) {
                return allMatches.subList(pageNumber * 5, allMatches.size());
            }

            for (int i = 0; i < 5; i++) {
                fiveMatches.add(allMatches.get((Integer) (pageNumber * 5 + i)));
            }
            return fiveMatches;
        } catch (IllegalArgumentException e) {
            throw new CustomException("Incorrect page number");
        }
    }

    public boolean CheckEndOfData(int pageNumber) {
        List<Match> allMatches = matchDao.findAll();

        if (allMatches.size() >= (pageNumber - 1) * 5 && allMatches.size() <= pageNumber  * 5) {
            return true;
        } else {
            return false;
        }

    }


    private static final MatchesService INSTANCE = new MatchesService();

    private MatchesService() {
    }

    public static MatchesService getInstance() {
        return INSTANCE;
    }
}
