package com.ethertons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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

    public boolean isNew() {
        return this.id == 0;
    }

}
