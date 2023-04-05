package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Column(name = "number")
    private int number;


    public Passport() {

    }

    public Passport(int number) {
        this.number = number;

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number=" + number +
                '}';
    }
}
