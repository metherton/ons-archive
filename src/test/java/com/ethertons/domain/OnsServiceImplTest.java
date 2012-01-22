package com.ethertons.domain;

import com.ethertons.persistence.ConfigDao;
import com.ethertons.persistence.PersonDao;
import com.ethertons.persistence.SurnameDao;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

public class OnsServiceImplTest {

    private PersonDao personDao;
    private ConfigDao configDao;
    private SurnameDao surnameDao;
    private Person person;
    private Surname surname;
    private OnsService onsService;

    @Before
    public void setUp() throws Exception {
        personDao = createMock(PersonDao.class);
        configDao = createMock(ConfigDao.class);
        surnameDao = createMock(SurnameDao.class);
        person = new Person();
        surname = new Surname();
        onsService = new OnsServiceImpl(personDao, configDao, surnameDao);
    }

    @Test
    public void findAuthorShouldReturnNameOfSiteAuthor() {
        expect(configDao.findAuthor()).andReturn("Martin Etherton");

        replay(configDao);
        onsService.findWebMaster();
        verify(configDao);
    }

    @Test
    public void findPersonWithIdShouldReturnCorrectPersonInfo() {
        expect(personDao.findPersonWith(1)).andReturn(person);

        replay(personDao);
        onsService.findPersonWith(1);
        verify(personDao);
    }

    @Test
    public void findAllSurnamesShouldRetrieveAllSurnames() {
        expect(surnameDao.findAllSurnames()).andReturn(new ArrayList<Surname>());

        replay(surnameDao);
        onsService.findAllSurnames();
        verify(surnameDao);
    }

    @Test
    public void findAllFathersShouldRetrieveAllMales() throws Exception {
        EasyMock.expect(personDao.findAllMalePersons()).andReturn(new ArrayList<Person>());

        replay(personDao);
        onsService.findAllMalePersons();
        verify(personDao);

    }

    @Test
    public void findAllMothersShouldRetrieveAllFemales() throws Exception {
        EasyMock.expect(personDao.findAllFemalePersons()).andReturn(new ArrayList<Person>());

        replay(personDao);
        onsService.findAllFemalePersons();
        verify(personDao);

    }


    @Test
    public void storePersonShouldStorePersonToDatabase() throws Exception {
        personDao.storePerson(person);

        replay(personDao);
        onsService.storePerson(person);
        verify(personDao);
    }

    @Test
    public void storeSurnameShouldStoreSurnameToDatabase() throws Exception {
        surnameDao.storeSurname(surname);

        replay(surnameDao);
        onsService.storeSurname(surname);
        verify(surnameDao);
    }

    @Test
    public void findAllPersonsShouldRetrieveAllPersons() throws Exception {
        EasyMock.expect(personDao.findAllPersons()).andReturn(new ArrayList<Person>());
        
        replay(personDao);
        onsService.findAllPersons();
        verify(personDao);
    }
}
