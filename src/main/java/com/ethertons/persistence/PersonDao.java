package com.ethertons.persistence;

import java.util.List;

import com.ethertons.domain.Person;

public interface PersonDao {
    Person findPersonWithId(int personId);

    void storePerson(Person person);

    List<Person> findAllMalePersons();

    List<Person> findAllFemalePersons();

    List<Person> findAllPersons(int personsPerPage);

    List<Person> findParentsFor(int personId);

    List<Person> findSiblingsFor(int personId);

    List<Person> findChildrenFor(Person father);

    List<Person> findWivesFor(int personId);

    List<Person> findChildrenForCouple(Person person, Person wife);

    List<Person> findSpousesFor(int activePersonId);

    List<Person> findAllDescendentsOfPerson(int treeId);
}
