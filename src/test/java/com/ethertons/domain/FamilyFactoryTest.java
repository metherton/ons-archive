package com.ethertons.domain;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

import java.util.ArrayList;
import java.util.List;

import com.ethertons.persistence.PersonDao;
import org.easymock.EasyMock;
import org.junit.Test;

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
        expect(personDao.findParentsFor(personId)).andReturn(persons);
        expect(personDao.findSiblingsFor(personId)).andReturn(persons);
        expect(personDao.findPersonWith(personId)).andReturn(person);
        expect(personDao.findChildrenFor(person)).andReturn(persons);
        EasyMock.replay(personDao);
        ImmediateFamily immediateFamily = FamilyFactory.buildImmediateFamilyFor(personId, personDao);
        EasyMock.verify(personDao);
        
    }
}
