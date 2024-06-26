package com.bma.util;

import com.bma.exception.DatabaseException;
import com.bma.model.Player;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            Configuration configuration = buildConfiguration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    private static Configuration buildConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(Player.class);
        return configuration;
    }
}
