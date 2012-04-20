package com.ethertons.domain;

import com.ethertons.persistence.PersonDao;

public class FamilyFactory {

    public static ImmediateFamily buildImmediateFamilyFor(int personId, PersonDao personDao) {
        ImmediateFamily immediateFamily = new ImmediateFamily();
        immediateFamily.setParents(personDao.findParentsFor(personId));
        immediateFamily.setSiblings(personDao.findSiblingsFor(personId));
        Person person = personDao.findPersonWith(personId);
        immediateFamily.setChildren(personDao.findChildrenFor(person));
        return immediateFamily;
    }
}
