package com.ethertons.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person")
public class Person {

    @Id
    @Column(name="person_id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="first_name", columnDefinition = "char")
    private String firstName;

    @ManyToOne
    @JoinColumn(name="surname_id", columnDefinition = "int",nullable = true)
    private Surname surname;

    @ManyToOne
    @JoinColumn(name="father_id", columnDefinition = "int")
    private Person father;

    @ManyToOne
    @JoinColumn(name="mother_id", columnDefinition = "int")
    private Person mother;

    public int getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public Surname getSurname() {
        return surname;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setSurname(Surname surname) {
        this.surname = surname;
    }
}
