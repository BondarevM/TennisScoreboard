package com.bma.util;

import lombok.experimental.UtilityClass;
import org.hibernate.Session;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@UtilityClass
public class DataLoaderUtil {
    public static void LoadData() {
        String sql;
        try {
            sql = new String(Files.readAllBytes(Paths.get(Objects.requireNonNull(
                    HibernateUtil.class.getClassLoader().getResource("data.sql")).toURI())));

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                session.createNativeQuery(sql, void.class).executeUpdate();
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            throw new RuntimeException("Database error!");
        }
    }
}
