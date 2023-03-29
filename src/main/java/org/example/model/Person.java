package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity обозначаем классы которые будут рабоать с Hibernate
//@Table указываем название которое сопоставляеться нужной нам ДБ

@Entity
@Table(name = "Person")
public class Person {

    //@Id обозначаем те поля в ДБ которые отмечены Primary Key
    //@Column сопоставляем колонки в ДБ с нашими полями
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }
}
