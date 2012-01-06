package com.ethertons.persistence;

import com.ethertons.domain.Person;

public interface PersonDao {
    Person findPersonWith(int personId);

    void storePerson(Person person);
}
