package com.ethertons.domain;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.List;

import com.ethertons.persistence.ConfigDao;
import com.ethertons.persistence.PersonDao;
import com.ethertons.persistence.SurnameDao;
import com.ethertons.persistence.TreeDao;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class OnsServiceImplTest {

    private PersonDao personDao;
    private ConfigDao configDao;
    private SurnameDao surnameDao;
    private Person person;
    private Surname surname;
    private Tree tree;
    private OnsService onsService;
    private TreeDao treeDao;

    @Before
    public void setUp() throws Exception {
        personDao = createMock(PersonDao.class);
        configDao = createMock(ConfigDao.class);
        surnameDao = createMock(SurnameDao.class);
        treeDao = createMock(TreeDao.class);
        person = new Person();
        surname = new Surname();
        tree = new Tree();
        onsService = new OnsServiceImpl(personDao, configDao, surnameDao, treeDao);
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
    public void findTreeWithIdShouldReturnTreeDetails() throws Exception {
        
        expect(treeDao.findTreeWith(1)).andReturn(tree);
        replay(treeDao);
        onsService.findTreeWith(1);
        verify(treeDao);
        
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
    public void storeTreeShouldStoreTreeToDatabase() throws Exception {
        treeDao.storeTree(tree);

        replay(treeDao);
        onsService.storeTree(tree);
        verify(treeDao);

    }

    @Test
    public void findAllPersonsShouldRetrieveAllPersons() throws Exception {
        EasyMock.expect(personDao.findAllPersons()).andReturn(new ArrayList<Person>());
        
        replay(personDao);
        onsService.findAllPersons();
        verify(personDao);
    }

    @Test
    public void findAllTreesShouldRetrieveAllTrees() throws Exception {
        expect(treeDao.findAllTrees()).andReturn(new ArrayList<Tree>());
        
        replay(treeDao);
        onsService.findAllTrees();
        verify(treeDao);
    }

    @Test
    public void findFamilyTreeShouldRetrieveFamilyTree() throws Exception {
        List<Person> parents = new ArrayList<Person>();
        Person father = new Person();
        Person mother = new Person();
        parents.add(father);
        parents.add(mother);
        expect(personDao.findParentsFor(1)).andReturn(parents);
        expect(personDao.findSiblingsFor(1)).andReturn(new ArrayList<Person>());
        expect(personDao.findChildrenFor(father)).andReturn(new ArrayList<Person>());
        
        replay(personDao);
        onsService.findRelativesFor(1);
        verify(personDao);

    }
}
