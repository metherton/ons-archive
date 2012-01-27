package com.ethertons.persistence;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import com.ethertons.domain.Tree;
import org.hamcrest.Matcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@DirtiesContext
public class OnsIntegrationTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ConfigDao configDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private SurnameDao surnameDao;

    @Autowired
    private TreeDao treeDao;

    private Session session;

    @Test
    public void canRetrieveAuthorsName() {
        String authorsName = configDao.findAuthor();
        assertThat(authorsName, is("Martin Etherton"));
    }

    @Test
    public void retrievesPersonInfo() {
        Person person = personDao.findPersonWith(15);
        assertThat(person.getFirstName(), is("martin"));
        assertThat(person.getSurname().getName(), is("etherton"));
        assertThat(person.getGender(), is(true));
    }

    @Test
    public void retrieveSurnames() {
        List<Surname> surnames = surnameDao.findAllSurnames();
        assertThat(surnames.size(), is(greaterThan(0)));
    }

    @Test
    public void retrieveAllMalePersons() throws Exception {
        List<Person> persons = personDao.findAllMalePersons();
        assertThat(persons.size(), is(greaterThan(0)));
        boolean femaleFound = false;
        for (Person person : persons) {
            if (! person.getGender()) {
                femaleFound = true;
                break;
            }
        }
        assertThat(femaleFound, is(false));
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

    @Test
    public void storeSurname() throws Exception {
        Surname surname = new Surname();
        surname.setName("testname1");
        surnameDao.storeSurname(surname);
    }

    @Test
    public void retrieveAllPersons() throws Exception {
        List<Person> persons = personDao.findAllPersons();
        assertThat(persons.size(), is(greaterThan(0)));
    }

    @Test
    public void retrieveTreeInfo() throws Exception {
        Tree tree = treeDao.findTreeWith(1);
        assertNotNull(tree);
        
    }

    @Test
    public void storeTree() throws Exception {
        Tree tree = new Tree();
        tree.setDescription("test tree 1");
        Person person = personDao.findPersonWith(1);
        tree.setPerson(person);
        treeDao.storeTree(tree);
    }
}
