package com.ethertons.persistence;

import com.ethertons.domain.Person;

import java.util.List;

public interface PersonDao {
    Person findPersonWith(int personId);

    void storePerson(Person person);

    List<Person> findAllMalePersons();

    List<Person> findAllFemalePersons();

    List<Person> findAllPersons();
}
