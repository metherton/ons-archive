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

    List<Person> findAllPersons(int personsPerPage);

    void storeTree(Tree tree);

    Tree findTreeWith(int treeId);

    List<Tree> findAllTrees();

    ImmediateFamily findRelativesFor(int personId);

    List<Gedcom> findAllGedcoms();

    void storeGedcom(Gedcom gedcom);

    Gedcom findGedcomWith(int gedcomId);

    List<Person> findPersonsFrom(int gedcomId);

    List<Person> findAllPersonsInTree(int treeId);
}
