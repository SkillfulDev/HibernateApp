package org.example;


//import jakarta.persistence.criteria.CriteriaQuery;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.NativeQuery;

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

            String hql = "update Person set age=2000 where age = 2200";

            Query<Person> query1 = session.createNativeQuery(hql,Person.class);

          query1.executeUpdate();


            //Выполняем транзакцию
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
