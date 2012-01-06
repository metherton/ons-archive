package com.ethertons.domain;

import javax.persistence.*;

@Entity
@Table(name="config")
public class Config {

    @Id
    @Column(name="config_id", columnDefinition = "int")
    private int id;

    @Column(name="description", columnDefinition = "char")
    private String description;

    @Column(name="value", columnDefinition = "char")
    private String value;
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

}
