package com.bma.servlet;

import com.bma.dao.PlayerDao;
import com.bma.model.Player;
import com.bma.util.DataLoaderUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.List;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            DataLoaderUtil.LoadData();
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
        String name = req.getParameter("name");

        PlayerDao playerDao = new PlayerDao();
        playerDao.save(name);

        List<Player> all = playerDao.findAll();



        try(PrintWriter writer = resp.getWriter()){
            writer.write("<h1>");
            writer.write("FOREACH");
            writer.write("</h1>");
            for (Player p: all) {
                writer.write("<h1>");
                writer.write(p.getName());
                writer.write("</h1>");
            }
            writer.write("<h1>");
            writer.write("GET");
            writer.write("</h1>");

            writer.write("<h1>");
            writer.write(playerDao.get(name).getName());
            writer.write("</h1>");
        }


    }

    @Override
    public void init() throws ServletException {
        DataLoaderUtil.LoadData();
    }
}
