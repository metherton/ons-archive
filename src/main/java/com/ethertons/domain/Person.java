package com.ethertons.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="person")
public class Person {

    @Id
    @Column(name="person_id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="first_name", columnDefinition = "char")
    @Size(min=1, max=10, message = "The first name must be between 1 and 10 characters long.")
    private String firstName;

    @ManyToOne
    @JoinColumn(name="surname_id", columnDefinition = "int",nullable = false)
    @NotNull
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
