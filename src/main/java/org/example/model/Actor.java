package org.example.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actor_id")
    private int actor_id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @ManyToMany()
    @JoinTable(joinColumns = @JoinColumn(name="actor_id"),
    inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movies;


    public Actor (){

    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Name = " + name+" || "+ "age= " +age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actor_id == actor.actor_id && age == actor.age && Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor_id, name, age);
    }
}
