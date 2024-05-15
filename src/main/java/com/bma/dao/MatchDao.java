package com.bma.dao;

import com.bma.model.Match;
import com.bma.model.Player;
import com.bma.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MatchDao {
    public List<Match> findAll() {
        String findAllHql = "FROM Match";
        try (Session session = HibernateUtil.buildSession()) {
            session.beginTransaction();

            List<Match> list = session.createQuery(findAllHql).list();

            session.getTransaction().commit();

            return list;
        }
    }

    public void save(Match match){

        try(Session session = HibernateUtil.buildSession()){
            session.beginTransaction();
            session.save(match);
            session.getTransaction().commit();
        }


    }

    private static final MatchDao INSTANCE = new MatchDao();
    private MatchDao(){}

    public static MatchDao getInstance(){
        return INSTANCE;
    }
}
