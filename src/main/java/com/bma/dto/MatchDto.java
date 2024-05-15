package com.bma.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDto {
    private String firstPlayerName;
    private String secondPlayerName;
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
