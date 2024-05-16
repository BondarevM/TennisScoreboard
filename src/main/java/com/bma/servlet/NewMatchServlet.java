package com.bma.servlet;

import com.bma.exception.PlayerNameException;
import com.bma.service.CreateNewMatchService;
import com.bma.service.MatchScoreCalculationService;
import com.bma.util.JspUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    private static final CreateNewMatchService createNewMatchService = CreateNewMatchService.getInstance();
    private static final MatchScoreCalculationService matchScoreCalculationService = MatchScoreCalculationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspUtil.getPath("newMatch")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstPlayerName = req.getParameter("firstPlayerName");
        String secondPlayerName = req.getParameter("secondPlayerName");

        String uuid = null;
        try {
            uuid = createNewMatchService.createNewMatch(firstPlayerName, secondPlayerName);
        } catch (PlayerNameException e) {
            req.setAttribute("playerNameException", e.getMessage());
            doGet(req, resp);
            req.getRequestDispatcher(JspUtil.getPath("newMatch")).forward(req, resp);
            return;
        }
        req.getRequestDispatcher("/match-score?uuid=" + uuid).forward(req, resp);
    }
}
