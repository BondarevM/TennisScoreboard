package com.bma.dao;

import com.bma.model.Player;
import com.bma.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PlayerDao {


    public void save(String name) {
        try (Session session = HibernateUtil.buildSession()) {
            session.beginTransaction();

            Player player = Player.builder()
                    .name(name)
                    .build();

            session.save(player);

            session.getTransaction().commit();
        }
    }

    public Player findByName(String name) {
        String hql = "FROM Player WHERE name = :name";
        try (Session session = HibernateUtil.buildSession()) {
            session.beginTransaction();

            Query query = session.createQuery(hql).setParameter("name", name);
            session.getTransaction().commit();

            return (Player) query.uniqueResult();
        }
    }

    public List<Player> findAll() {
        String findAllHql = "FROM Player";
        try (Session session = HibernateUtil.buildSession();
        ) {
            session.beginTransaction();

            List<Player> list = session.createQuery(findAllHql).list();

            session.getTransaction().commit();

            return list;
        }
    }

    private static final PlayerDao INSTANCE = new PlayerDao();

    private PlayerDao() {
    }

    public static PlayerDao getInstance() {
        return INSTANCE;
    }

}
