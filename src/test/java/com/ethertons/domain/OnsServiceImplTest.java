package com.ethertons.domain;

import com.ethertons.persistence.ConfigDao;
import com.ethertons.persistence.PersonDao;
import com.ethertons.persistence.SurnameDao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

public class OnsServiceImplTest {

    @Test
    public void findAuthorShouldReturnNameOfSiteAuthor() {
        String authorsName = "Martin Etherton";
        PersonDao personDao = createMock(PersonDao.class);
        ConfigDao configDao = createMock(ConfigDao.class);
        SurnameDao surnameDao = createMock(SurnameDao.class);
        expect(configDao.findAuthor()).andReturn(authorsName);
        
        replay(configDao);

        OnsService onsService = new OnsServiceImpl(personDao, configDao, surnameDao);
        onsService.findWebMaster();
        verify(configDao);
    }
    
    @Test
    public void findPersonWithIdShouldReturnCorrectPersonInfo() {
        Person person = new Person();
        PersonDao personDao = createMock(PersonDao.class);
        ConfigDao configDao = createMock(ConfigDao.class);
        expect(personDao.findPersonWith(1)).andReturn(person);

        SurnameDao surnameDao = createMock(SurnameDao.class);
        OnsService onsService = new OnsServiceImpl(personDao, configDao, surnameDao);
        
        replay(personDao);
        onsService.findPersonWith(1);
        verify(personDao);
    }

    @Test
    public void findAllSurnamesShouldRetrieveAllSurnames() {

        SurnameDao surnameDao = createMock(SurnameDao.class);
        
        List<Surname> surnames = new ArrayList<Surname>();
        surnames.add(new Surname());
        surnames.add(new Surname());
        
        OnsService onsService = new OnsServiceImpl(null, null, surnameDao);
        expect(surnameDao.findAllSurnames()).andReturn(surnames);

        replay(surnameDao);
        onsService.findAllSurnames();
        verify(surnameDao);
        
    }

    @Test
    public void storePersonShouldStorePersonToDatabase() throws Exception {


        PersonDao personDao = createMock(PersonDao.class);
        Person person = null;
        OnsService onsService = new OnsServiceImpl(personDao, null, null);
        replay(personDao);
        onsService.storePerson(person);
        verify(personDao);
    }
}
