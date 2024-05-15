package com.bma.service;

import com.bma.model.Match;
import com.bma.model.MatchScore;

public class MatchScoreCalculationService {
    private Match currentMatch;
    private MatchScore matchScore;

    public void winsGoal(String firstPlayerButton, String secondPlayerButton, Match currentMatch) {
        this.currentMatch = currentMatch;
        matchScore = currentMatch.getMatchScore();
        if (matchScore.isTieBreak()) {
            if (firstPlayerButton != null) {
                matchScore.setFirstPlayerScore(matchScore.getFirstPlayerScore() + 1);

                if (matchScore.getFirstPlayerScore() == 7 && matchScore.getSecondPlayerScore() <= 5) {
                    winsGame(firstPlayerButton, secondPlayerButton);
                }

                if (matchScore.getFirstPlayerScore() >= 6 && matchScore.getSecondPlayerScore() >= 6) {
                    if ((matchScore.getFirstPlayerScore() - matchScore.getSecondPlayerScore()) == 2) {
                        winsGame(firstPlayerButton, secondPlayerButton);
                    }
                }
            }
            if (secondPlayerButton != null) {
                matchScore.setSecondPlayerScore(matchScore.getSecondPlayerScore() + 1);
                if (matchScore.getSecondPlayerScore() == 7 && matchScore.getFirstPlayerScore() <= 5) {
                    winsGame(firstPlayerButton, secondPlayerButton);
                }

                if (matchScore.getFirstPlayerScore() >= 6 && matchScore.getSecondPlayerScore() >= 6) {
                    if ((matchScore.getSecondPlayerScore() - matchScore.getFirstPlayerScore()) == 2) {
                        winsGame(firstPlayerButton, secondPlayerButton);
                    }
                }
            }
        } else {
            if (firstPlayerButton != null) {
                if (matchScore.getFirstPlayerScore() == 0) {
                    matchScore.setFirstPlayerScore(15);
                } else if (matchScore.getFirstPlayerScore() == 15) {
                    matchScore.setFirstPlayerScore(30);
                } else if (matchScore.getFirstPlayerScore() == 30 && matchScore.getSecondPlayerScore() == 40) {
                    matchScore.setWinByTwo(true);
                    matchScore.setFirstPlayerScore(40);
                } else if (matchScore.getFirstPlayerScore() == 30) {
                    matchScore.setFirstPlayerScore(40);
                } else if (matchScore.getSecondPlayerScore() != 40) {
                    winsGame(firstPlayerButton, secondPlayerButton);
                } else if (matchScore.getSecondPlayerScore() == 40 && !matchScore.isFirstPlayerAdIn() && !matchScore.isSecondPlayerAdIn()) {
                    matchScore.setFirstPlayerAdIn(true);
                } else if (matchScore.getSecondPlayerScore() == 40 && matchScore.isSecondPlayerAdIn()) {
                    matchScore.setSecondPlayerAdIn(false);
                } else if (matchScore.getSecondPlayerScore() == 40 && matchScore.isFirstPlayerAdIn()) {
                    winsGame(firstPlayerButton, secondPlayerButton);
                }
            }

            if (secondPlayerButton != null) {
                if (matchScore.getSecondPlayerScore() == 0) {
                    matchScore.setSecondPlayerScore(15);
                } else if (matchScore.getSecondPlayerScore() == 15) {
                    matchScore.setSecondPlayerScore(30);
                } else if (matchScore.getSecondPlayerScore() == 30 && matchScore.getFirstPlayerScore() == 40) {
                    matchScore.setWinByTwo(true);
                    matchScore.setSecondPlayerScore(40);
                } else if (matchScore.getSecondPlayerScore() == 30) {
                    matchScore.setSecondPlayerScore(40);
                } else if (matchScore.getFirstPlayerScore() != 40) {
                    winsGame(firstPlayerButton, secondPlayerButton);
                } else if (matchScore.getFirstPlayerScore() == 40 && !matchScore.isFirstPlayerAdIn() && !matchScore.isSecondPlayerAdIn()) {
                    matchScore.setSecondPlayerAdIn(true);
                } else if (matchScore.getFirstPlayerScore() == 40 && matchScore.isFirstPlayerAdIn()) {
                    matchScore.setFirstPlayerAdIn(false);
                } else if (matchScore.getFirstPlayerScore() == 40 && matchScore.isSecondPlayerAdIn()) {
                    winsGame(firstPlayerButton, secondPlayerButton);
                }
            }
        }


    }

    private void winsGame(String firstPlayerButton, String secondPlayerButton) {
        setInitParamsWinningGame();
        if (firstPlayerButton != null) {
            switch (matchScore.getFirstPlayerGame()) {
                case 0:
                    matchScore.setFirstPlayerGame(1);
                    break;
                case 1:
                    matchScore.setFirstPlayerGame(2);
                    break;
                case 2:
                    matchScore.setFirstPlayerGame(3);
                    break;
                case 3:
                    matchScore.setFirstPlayerGame(4);
                    break;
                case 4:
                    matchScore.setFirstPlayerGame(5);
                    break;
                case 5:
                    if (matchScore.getSecondPlayerGame() != 5 && matchScore.getSecondPlayerGame() != 6) {
                        winsSet(firstPlayerButton, secondPlayerButton);
                    } else if (matchScore.getSecondPlayerGame() == 6) {
                        matchScore.setFirstPlayerGame(6);
                        matchScore.setTieBreak(true);
                    } else {
                        matchScore.setFirstPlayerGame(6);
                    }
                    break;
                case 6:
                    winsSet(firstPlayerButton, secondPlayerButton);
                    break;
            }
        }

        if (secondPlayerButton != null) {
            switch (matchScore.getSecondPlayerGame()) {
                case 0:
                    matchScore.setSecondPlayerGame(1);
                    break;
                case 1:
                    matchScore.setSecondPlayerGame(2);
                    break;
                case 2:
                    matchScore.setSecondPlayerGame(3);
                    break;
                case 3:
                    matchScore.setSecondPlayerGame(4);
                    break;
                case 4:
                    matchScore.setSecondPlayerGame(5);
                    break;
                case 5:
                    if (matchScore.getFirstPlayerGame() != 5 && matchScore.getFirstPlayerGame() != 6) {
                        winsSet(firstPlayerButton, secondPlayerButton);
                    } else if (matchScore.getFirstPlayerGame() == 6) {
                        matchScore.setSecondPlayerGame(6);
                        matchScore.setTieBreak(true);
                    } else {
                        matchScore.setSecondPlayerGame(6);
                    }
                    break;
                case 6:
                    winsSet(firstPlayerButton, secondPlayerButton);
                    break;

            }
        }
    }


    private void winsSet(String firstPlayerButton, String secondPlayerButton) {
        setInitParamsWinningSet();
        if (firstPlayerButton != null) {
            switch (matchScore.getFirstPlayerSet()) {
                case 0:
                    matchScore.setFirstPlayerSet(1);
                    break;
                case 1:
                    currentMatch.setWinner(currentMatch.getPlayer1());
                    matchScore.setFirstPlayerSet(2);
                    matchScore.setMatchFinished(true);
                    break;
            }
        }

        if (secondPlayerButton != null) {
            switch (matchScore.getSecondPlayerSet()) {
                case 0:
                    matchScore.setSecondPlayerSet(1);
                    break;
                case 1:
                    currentMatch.setWinner(currentMatch.getPlayer2());
                    matchScore.setSecondPlayerSet(2);
                    matchScore.setMatchFinished(true);

                    break;
            }
        }
    }

    private void setInitParamsWinningSet() {
        matchScore.setFirstPlayerGame(0);
        matchScore.setSecondPlayerGame(0);
        setInitParamsWinningGame();
    }

    private void setInitParamsWinningGame() {
        matchScore.setWinByTwo(false);
        matchScore.setTieBreak(false);
        matchScore.setFirstPlayerScore(0);
        matchScore.setSecondPlayerScore(0);
        matchScore.setFirstPlayerAdIn(false);
        matchScore.setSecondPlayerAdIn(false);
    }



    private MatchScoreCalculationService() {
    }

    private static final MatchScoreCalculationService INSTANCE = new MatchScoreCalculationService();

    public static MatchScoreCalculationService getInstance() {
        return INSTANCE;
    }
}
