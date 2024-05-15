package com.bma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchScore {
    int firstPlayerScore;
    int secondPlayerScore;
    int firstPlayerGame;
    int secondPlayerGame;
    int firstPlayerSet;
    int secondPlayerSet;
    boolean winByTwo;
    boolean firstPlayerAdIn;
    boolean secondPlayerAdIn;
    boolean tieBreak;
    boolean matchFinished;
}
