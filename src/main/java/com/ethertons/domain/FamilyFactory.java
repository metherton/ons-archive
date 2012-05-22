package com.ethertons.domain;

import com.ethertons.persistence.PersonDao;

public class FamilyFactory {

    public static ImmediateFamily buildImmediateFamilyFor(int personId, PersonDao personDao) {
        ImmediateFamily immediateFamily = ImmediateFamily.build(personId, personDao);
        return immediateFamily;
    }
}
