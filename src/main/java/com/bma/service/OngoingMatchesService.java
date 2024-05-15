package com.bma.service;

import com.bma.dto.MatchDto;
import com.bma.model.Match;

import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    ConcurrentHashMap<String, Match> currentMatches = new ConcurrentHashMap<>();

    public String putNewMatch(String uuid, Match match){
        currentMatches.put(uuid, match);
        return uuid;
    }

    public MatchDto getCurrentMatch(String uuid){


        Match match = currentMatches.get(uuid);
    }


    public static OngoingMatchesService getInstance(){return  INSTANCE;}
    private static final OngoingMatchesService INSTANCE = new OngoingMatchesService();
    private OngoingMatchesService(){}
}
