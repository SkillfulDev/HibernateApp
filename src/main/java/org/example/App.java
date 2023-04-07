package org.example;


//import jakarta.persistence.criteria.CriteriaQuery;

//import org.example.model.Item;

import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Для начала мы должны подключить наш файл Hibernate.properties, для этого используем
        // класс Configuration, он автоматически подключается к нашему файлу
        Configuration configuration = new Configuration().
                addAnnotatedClass(Actor.class).
                addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //Создаем сессию для работы с Hibernate
        Session session = sessionFactory.getCurrentSession();
        try (sessionFactory) {
//        Начинаем транзакцию
            session.beginTransaction();
            Movie movie = session.get(Movie.class, 1);
            Actor actor = session.get(Actor.class,1);
            actor.getMovies().remove(movie);
            movie.getActors().remove(actor);

            //Выполняем транзакцию
            session.getTransaction().commit();
        }

    }
}
//           String hql = "update Person set age=2000 where age = 2200";
//
//            Query<Person> query1 = session.createNativeQuery(hql, Person.class);
//
//            query1.executeUpdate();