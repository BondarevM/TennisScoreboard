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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNumber = "1";

        if (req.getParameter("pageNumber")!= null){
            pageNumber = req.getParameter("pageNumber");
        }

//        List<Match> matches = matchService.findAll();

        List<Match> matches = null;
        try {
            matches = matchService.findAll(Integer.parseInt(pageNumber));

            if (matchService.CheckEndOfData(Integer.parseInt(pageNumber))){
                req.setAttribute("DataRanOut", true);
            }
        } catch (CustomException e) {
            req.setAttribute("errorOccurred", true);

        }


        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("matches", matches);


        req.getRequestDispatcher(JspUtil.getPath("matches")).forward(req, resp);
    }
}
