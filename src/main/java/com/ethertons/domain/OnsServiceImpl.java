package com.ethertons.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethertons.persistence.ConfigDao;
import com.ethertons.persistence.GedcomDao;
import com.ethertons.persistence.PersonDao;
import com.ethertons.persistence.SurnameDao;
import com.ethertons.persistence.TreeDao;

@Service
public class OnsServiceImpl implements OnsService {

    private final PersonDao personDao;
    private final ConfigDao configDao;
    private final SurnameDao surnameDao;
    private final TreeDao treeDao;
    private final GedcomDao gedcomDao;

    @Autowired
    public OnsServiceImpl(PersonDao personDao, ConfigDao configDao, SurnameDao surnameDao, TreeDao treeDao, GedcomDao gedcomDao) {
        this.personDao = personDao;
        this.configDao = configDao;
        this.surnameDao = surnameDao;
        this.treeDao =  treeDao;
        this.gedcomDao = gedcomDao;
    }


    @Override
    public String findWebMaster() {
        return configDao.findAuthor();
    }

    @Override
    public Person findPersonWith(int personId) {
        return personDao.findPersonWithId(personId);
    }

    @Override
    public Surname findSurnameWith(int surnameId) {
        return surnameDao.findSurnameWith(surnameId);
    }

    @Override
    public void storeSurname(Surname surname) {
        surnameDao.storeSurname(surname);
    }

    @Override
    public List<Person> findAllMalePersons() {
        return personDao.findAllMalePersons();
    }

    @Override
    public List<Person> findAllFemalePersons() {
        return personDao.findAllFemalePersons();
    }


    @Override
    public void storeTree(Tree tree) {
        treeDao.storeTree(tree);
    }

    @Override
    public Tree findTreeWith(int treeId) {
        return treeDao.findTreeWith(treeId);
    }

    @Override
    public List<Tree> findAllTrees() {
        return treeDao.findAllTrees();
    }

    @Override
    public ImmediateFamily findRelativesFor(int personId) {
        return FamilyFactory.buildImmediateFamilyFor(personId, personDao);
    }

    @Override
    public List<Gedcom> findAllGedcoms() {
        return gedcomDao.findAllGedcoms();
    }

    @Override
    public void storeGedcom(Gedcom gedcom) {
        gedcomDao.storeGedcom(gedcom);
    }

    @Override
    public Gedcom findGedcomWith(int gedcomId) {
        return gedcomDao.findGedcomWith(gedcomId);
    }

    @Override
    public List<Person> findPersonsFrom(int gedcomId) {

        return null;
    }

    @Override
    public List<Person> findAllPersonsInTree(int treeId) {
        Tree tree = treeDao.findTreeWith(treeId);
        return personDao.findAllDescendentsOfPerson(tree.getPerson().getId());
    }

    @Override
    public List<Surname> findAllSurnames() {
        return surnameDao.findAllSurnames();
    }

    @Override
    public void storePerson(Person person) {
        personDao.storePerson(person);
    }


    @Override
    public List<Person> findAllPersons(int personsPerPage) {
        return personDao.findAllPersons(personsPerPage);
    }
}
