package com.ethertons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gedcom")
public class Gedcom {

    @Id
    @Column(name="gedcom_id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="title", columnDefinition = "char")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isNew() {
        return this.id == 0;
    }

}
