package com.ethertons.domain;

import java.util.List;

import com.ethertons.persistence.PersonDao;

public class ImmediateFamily {

    private List<Person> parents;
    private List<Person> siblings;
    private List<Person> children;
    private List<Person> wives;

    private int activePersonId;

    private final PersonDao personDao;

    private ImmediateFamily(int activePersonId, PersonDao personDao) {
        this.activePersonId = activePersonId;
        this.personDao = personDao;
    }

    public List<Person> getSpouses() {
        return personDao.findSpousesFor(activePersonId);
    }

    public List<Person> getParents() {
        return personDao.findParentsFor(activePersonId);
    }

    public List<Person> getSiblings() {
        return personDao.findSiblingsFor(activePersonId);
    }

    public List<Person> getChildrenWithWife(int wifeId) {
        Person person = personDao.findPersonWithId(activePersonId);
        Person wife = personDao.findPersonWithId(wifeId);
        if (person.getGender()) {
            return personDao.findChildrenForCouple(person, wife);
        } else {
            return personDao.findChildrenForCouple(wife, person);
        }
    }

    public int findSiblingPosition(int personId) {
        int position = 0;
        for (Person person: getSiblings()) {
            if (person.getId() == personId) {
                return position;
            }
            position++;
        }
        return position;
    }

    public int getActivePersonId() {
        return activePersonId;
    }

    public void setActivePersonId(int activePersonId) {
        this.activePersonId = activePersonId;
    }

    public static ImmediateFamily build(int activePersonId, PersonDao personDao) {
        ImmediateFamily immediateFamily = new ImmediateFamily(activePersonId, personDao);
        return immediateFamily;
    }
}
