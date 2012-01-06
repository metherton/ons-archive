package com.ethertons.persistence;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import org.hamcrest.Matcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class OnsIntegrationTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ConfigDao configDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private SurnameDao surnameDao;

    private Session session;    
    

    @Test
    public void canRetrieveAuthorsName() {
        String authorsName = configDao.findAuthor();
        assertThat(authorsName, is("Martin Etherton"));
    }
    
    @Test
    public void retrievesPersonInfo() {
        Person person = personDao.findPersonWith(1);
        assertThat(person.getFirstName(), is("martin"));
        assertThat(person.getSurname().getName(), is("etherton"));
        assertThat(person.getFather().getFirstName(), is("sydney"));
        assertThat(person.getFather().getSurname().getName(), is("etherton"));
        assertThat(person.getMother().getFirstName(), is("nora"));
        assertThat(person.getMother().getSurname().getName(), is("wilkinson"));

    }

    
    @Test
    public void retrieveSurnames() {
        List<Surname> surnames = surnameDao.findAllSurnames();
        assertThat(surnames.size(), is(greaterThan(0)));
    }

    @Test
    public void storePerson() throws Exception {
        
        Person person = new Person();
        person.setFirstName("Richard");
        Surname surname = new Surname();
        surname.setName("Etherton");
        surname.setId(1);
        person.setSurname(surname);

        personDao.storePerson(person);
        
    }
}
