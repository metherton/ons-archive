package com.ethertons.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="person")
public class Person {

    @Id
    @Column(name="person_id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="first_name", columnDefinition = "char")
    @Size(min=1, max=50, message = "The first name must be between 1 and 50 characters long.")
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

    @Column(name="gender", columnDefinition = "boolean")
    private boolean gender;

    @Column(name="fullname", columnDefinition = "char")
    private String fullname;

    @Column(name="date_of_birth", columnDefinition = "date")
    private Date birthDate;

    public Person() {

    }
    
    private Person(Builder builder) {
        id = builder.personId;
        firstName = builder.firstName;
        surname = builder.surname;
    }

    public boolean isNew() {
        return this.id == 0;
    }

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

    public boolean getGender() {
        return gender;
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

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (fullname != null ? !fullname.equals(person.fullname) : person.fullname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        return result;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public static class Builder {
        
        private final int personId;
        private String firstName;
        private Surname surname;

        
        public Builder(int personId) {
            this.personId = personId;
        }


        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder surname(Surname surname) {
            this.surname = surname;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
