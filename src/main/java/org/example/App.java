package org.example;


import jakarta.persistence.criteria.CriteriaQuery;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.query.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Для начала мы должны подключить наш файл Hibernate.properties, для этого используем
        // класс Configuration, он автоматически подключается к нашему файлу
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //Создаем сессию для работы с Hibernate
        Session session = sessionFactory.getCurrentSession();
        try {
//        Начинаем транзакцию
            session.beginTransaction();

            CriteriaQuery<Person> pr = session.getCriteriaBuilder().createQuery(Person.class);
            pr.from(Person.class);

            List<Person> people = session.createQuery(pr).getResultList();

            //Выполняем транзакцию
            for (Person person1 : people) {
                System.out.println(person1);
            }
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
