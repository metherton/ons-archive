package com.ethertons.domain;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ethertons.persistence.PersonDao;

public class FamilyFactoryTest {

    private PersonDao personDao;

    @Test
    public void immediateFamilyShouldBeBuilt() throws Exception {

        int personId = 1;
        Person person = new Person();
        person.setId(personId);
        List<Person> persons = new ArrayList<Person>();
        persons.add(person);
        personDao = createMock(PersonDao.class);
        replay(personDao);
        ImmediateFamily immediateFamily = FamilyFactory.buildImmediateFamilyFor(personId, personDao);
        verify(personDao);
        
    }
}
