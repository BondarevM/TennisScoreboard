package com.bma.model;


import com.bma.util.DataLoaderUtil;
import com.bma.util.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HibernateRunnerTest {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String sql;
        try(Session session = HibernateUtil.buildSession()){
            DataLoaderUtil.LoadData();
            session.beginTransaction();

            Player player = Player.builder()
                    .name("Mishanya")
                    .build();
            session.save(player);

            List<Player> fromPlayer = session.createQuery("FROM Player").getResultList();

            for (Player p: fromPlayer){
                System.out.println(p.getName());
            }

            List<Match> fromMatch = session.createQuery("FROM Match").getResultList();
            for (Match m : fromMatch){
                System.out.println(m);
            }



            session.getTransaction().commit();

      }
    }
}
