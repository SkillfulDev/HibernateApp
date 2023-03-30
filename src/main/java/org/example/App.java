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
            String hql = "select person from Person person where person.age  >20";
            Query<Person> query = session.createQuery(hql, Person.class);
            List<Person> people = query.list();
            for (Person person : people) {
                System.out.println(person);
            }

            //Выполняем транзакцию
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
