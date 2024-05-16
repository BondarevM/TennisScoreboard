package com.bma.service;

import com.bma.model.Match;

import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    ConcurrentHashMap<String, Match> currentMatches = new ConcurrentHashMap<>();

    public String putNewMatch(String uuid, Match match) {
        currentMatches.put(uuid, match);
        return uuid;
    }

    public Match getCurrentMatch(String uuid) {
        return currentMatches.get(uuid);
    }

    public void deleteMatch(String uuid) {
        currentMatches.remove(uuid);
    }

    public static OngoingMatchesService getInstance() {
        return INSTANCE;
    }

    private static final OngoingMatchesService INSTANCE = new OngoingMatchesService();

    private OngoingMatchesService() {
    }
}
