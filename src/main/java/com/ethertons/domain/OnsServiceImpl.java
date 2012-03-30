package com.ethertons.domain;

import java.util.List;

import com.ethertons.persistence.ConfigDao;
import com.ethertons.persistence.PersonDao;
import com.ethertons.persistence.SurnameDao;
import com.ethertons.persistence.TreeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnsServiceImpl implements OnsService {

    private final PersonDao personDao;
    private final ConfigDao configDao;
    private final SurnameDao surnameDao;
    private final TreeDao treeDao;

    @Autowired
    public OnsServiceImpl(PersonDao personDao, ConfigDao configDao, SurnameDao surnameDao, TreeDao treeDao) {
        this.personDao = personDao;
        this.configDao = configDao;
        this.surnameDao = surnameDao;
        this.treeDao =  treeDao;
    }


    @Override
    public String findWebMaster() {
        return configDao.findAuthor();
    }

    @Override
    public Person findPersonWith(int personId) {
        return personDao.findPersonWith(personId);
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
    public List<Person> findAllPersons() {
        return personDao.findAllPersons();
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
    public Relatives findRelativesFor(int personId) {
        Relatives relatives = new Relatives();
        relatives.setParents(personDao.findParentsFor(personId));
        relatives.setSiblings(personDao.findSiblingsFor(personId));
        Person person = personDao.findPersonWith(personId);
        relatives.setChildren(personDao.findChildrenFor(person));
        return relatives;
    }

    @Override
    public List<Surname> findAllSurnames() {
        return surnameDao.findAllSurnames();
    }

    @Override
    public void storePerson(Person person) {
        personDao.storePerson(person);
    }
}
