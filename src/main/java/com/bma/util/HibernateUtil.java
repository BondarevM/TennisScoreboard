package com.bma.util;

import com.bma.model.Player;
import org.hibernate.Session;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static Session buildSession(){

        Configuration configuration = buildConfiguration();
        configuration.configure();
        configuration.buildSessionFactory().openSession();
        return configuration.buildSessionFactory().openSession();

    }

    private static Configuration buildConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.addAnnotatedClass(Player.class);
        return configuration;
    }

}
