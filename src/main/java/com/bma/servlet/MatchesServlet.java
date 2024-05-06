package com.bma.servlet;

import com.bma.exception.CustomException;
import com.bma.model.Match;
import com.bma.service.MatchesService;
import com.bma.util.JspUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class MatchesServlet extends HttpServlet {

    private static final MatchesService matchService = MatchesService.getInstance();

    private String pageNumber = "1";
    private String playerName = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("pageNumber") != null) {
            pageNumber = req.getParameter("pageNumber");
        }

        List<Match> matches = null;

        if (req.getParameter("playerName") != null) {
            playerName = req.getParameter("playerName");
        }

        try {
            matches = matchService.findAll(Integer.parseInt(pageNumber), playerName);

            if (matchService.CheckEndOfData(Integer.parseInt(pageNumber), playerName)) {
                req.setAttribute("DataRanOut", true);
            }

        } catch (CustomException e) {
            resp.sendError(415, e.getMessage());
            return;
        }


        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("matches", matches);
        req.setAttribute("playerName", playerName);


        req.getRequestDispatcher(JspUtil.getPath("matches")).forward(req, resp);
    }
}
