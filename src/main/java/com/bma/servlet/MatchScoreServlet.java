package com.bma.servlet;

import com.bma.model.Match;
import com.bma.service.FinishedMatchesPersistenceService;
import com.bma.service.MatchScoreCalculationService;
import com.bma.service.OngoingMatchesService;
import com.bma.util.JspUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/match-score")
public class MatchScoreServlet extends HttpServlet {
    private static final OngoingMatchesService ongoingMatchesService = OngoingMatchesService.getInstance();
    private static final MatchScoreCalculationService matchScoreCalculationService = MatchScoreCalculationService.getInstance();
    private static final FinishedMatchesPersistenceService finishedMatchesPersistenceService = FinishedMatchesPersistenceService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name1 = req.getParameter("firstPlayerName");
        String name2 = req.getParameter("secondPlayerName");

        String firstPlayerButton = req.getParameter("player1");
        String secondPlayerButton = req.getParameter("player2");

        String uuid = req.getParameter("uuid");

        Match currentMatch = ongoingMatchesService.getCurrentMatch(uuid);


        String firstPlayerName = currentMatch.getPlayer1().getName();
        String secondPlayerName = currentMatch.getPlayer2().getName();


        matchScoreCalculationService.winsGoal(firstPlayerButton, secondPlayerButton, currentMatch);


        req.setAttribute("firstPlayerName", firstPlayerName);
        req.setAttribute("secondPlayerName", secondPlayerName);


        if (currentMatch.getMatchScore().isMatchFinished()) {
            if (!currentMatch.getIsSaved()) {
                req.setAttribute("matchFinished", true);
                req.setAttribute("winner", currentMatch.getWinner().getName());
                finishedMatchesPersistenceService.saveMatch(currentMatch);
                currentMatch.setIsSaved(true);
            }
        }

        if (currentMatch.getMatchScore().isWinByTwo()) {
            if (currentMatch.getMatchScore().isFirstPlayerAdIn()) {
                req.setAttribute("firstPlayerAdIn", "Ad");
            }

            if (currentMatch.getMatchScore().isSecondPlayerAdIn()) {
                req.setAttribute("secondPlayerAdIn", "Ad");
            }

        }

        req.setAttribute("winByTwo", currentMatch.getMatchScore().isWinByTwo());

        req.setAttribute("firstPlayerScore", Integer.toString(currentMatch.getMatchScore().getFirstPlayerScore()));
        req.setAttribute("firstPlayerScore", Integer.toString(currentMatch.getMatchScore().getFirstPlayerScore()));
        req.setAttribute("secondPlayerScore", Integer.toString(currentMatch.getMatchScore().getSecondPlayerScore()));

        req.setAttribute("firstPlayerGame", Integer.toString(currentMatch.getMatchScore().getFirstPlayerGame()));
        req.setAttribute("secondPlayerGame", Integer.toString(currentMatch.getMatchScore().getSecondPlayerGame()));

        req.setAttribute("firstPlayerSet", Integer.toString(currentMatch.getMatchScore().getFirstPlayerSet()));
        req.setAttribute("secondPlayerSet", Integer.toString(currentMatch.getMatchScore().getSecondPlayerSet()));


        req.getRequestDispatcher(JspUtil.getPath("matchScore") + "?uuid=" + uuid).forward(req, resp);
    }
}
