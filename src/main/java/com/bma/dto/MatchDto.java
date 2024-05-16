package com.bma.dto;

import com.bma.model.Player;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDto {
    private Player player1;
    private Player player2;
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
