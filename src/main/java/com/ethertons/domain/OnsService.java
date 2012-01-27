package com.ethertons.domain;

import java.util.List;

public interface OnsService {
    public String findWebMaster();

    Person findPersonWith(int personId);

    List<Surname> findAllSurnames();

    void storePerson(Person person);

    Surname findSurnameWith(int surnameId);

    void storeSurname(Surname surname);

    List<Person> findAllMalePersons();

    List<Person> findAllFemalePersons();

    List<Person> findAllPersons();

    void storeTree(Tree tree);

    Tree findTreeWith(int treeId);
}
