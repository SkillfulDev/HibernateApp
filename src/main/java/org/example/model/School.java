package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name="school")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="school_number")
    private int schoolNumber;

    @OneToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    public School (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;

    }

    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolNumber=" + schoolNumber +
                ", director=" + director +
                '}';
    }
}
