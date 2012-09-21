package com.ethertons.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import com.ethertons.domain.Tree;
import org.hamcrest.Matchers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
        Person person = personDao.findPersonWithId(5);
        assertThat(person.getFirstName(), is("Sydney Arthur (Jr)"));
        assertThat(person.getSurname().getName(), is("Etherton"));
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
        Person person = personDao.findPersonWithId(5);
        tree.setPerson(person);
        treeDao.storeTree(tree);
    }

    @Test
    public void retrieveAllTrees() throws Exception {
        List<Tree> trees = treeDao.findAllTrees();
        assertThat(trees.size(), is(greaterThan(0)));
    }
    
    @Test
    public void retrieveFamilyTree() throws Exception {
        List<Person> parents = personDao.findParentsFor(6);
        assertThat(parents.size(), is(2));
        List<Person> siblings = personDao.findSiblingsFor(6);
        assertThat(siblings.size(), is(3));
        List<Person> wives = personDao.findWivesFor(6);
        assertThat(wives.size(), Matchers.is(1));
        Person father = personDao.findPersonWithId(6);
        Person mother = personDao.findPersonWithId(10);
        List<Person> children = personDao.findChildrenFor(father);
        assertThat(children.size(), Matchers.is(1));
    }

    @Test
    public void findAllPersonsInTree() throws Exception {
        List<Person> personsInTree = personDao.findAllPersonsInTree(1);
        assertThat(personsInTree.size(), greaterThan(1));
    }
}
