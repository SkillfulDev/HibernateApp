package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "item_name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item() {

    }

    public Item(String name,Person person) {
        this.name = name;
        this.owner=person;
    }

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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return name;
    }
}
