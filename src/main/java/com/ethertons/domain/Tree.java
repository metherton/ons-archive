package com.ethertons.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tree")
public class Tree {

    public int getId() {
        return id;
    }

    @Id
    @Column(name="tree_id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne
    @JoinColumn(name="person_id", columnDefinition = "int",nullable = false)
    @NotNull
    private Person person;

    @Column(name="description", columnDefinition = "text")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
