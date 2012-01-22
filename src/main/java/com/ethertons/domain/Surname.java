package com.ethertons.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="surname")
public class Surname {

    public int getId() {
        return id;
    }

    @Id
    @Column(name="surname_id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name", columnDefinition = "char")
    @Size(min=1, max=50, message = "The first name must be between 1 and 50 characters long.")
    private String name;

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
