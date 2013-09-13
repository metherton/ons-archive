package com.ethertons.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ethertons.common.TreeResolver;
import com.ethertons.domain.Person;

@Repository
@Transactional
public class PersonDaoImpl extends GenericDao implements PersonDao {

    private final TreeResolver treeResolver;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory, TreeResolver treeResolver) {
        super(sessionFactory);
        this.treeResolver = treeResolver;
    }

    @Override
    public Person findPersonWithId(int personId) {
        Person person = (Person)currentSession().get(Person.class, personId);
        return person != null ? person : new Person.Builder(0).fullname("Unknown").build();
    }

    @Override
    public void storePerson(Person person) {
        currentSession().merge(person);
    }

    @Override
    public List<Person> findAllMalePersons() {
        return (List<Person>)currentSession().createCriteria(Person.class).
                                                add(Restrictions.eq("gender", true)).
                                                addOrder(Order.asc("birthDate")).
                                                list();
    }

    @Override
    public List<Person> findAllFemalePersons() {
        return (List<Person>)currentSession().createCriteria(Person.class).
                add(Restrictions.eq("gender", false)).
                addOrder(Order.asc("birthDate")).
                list();
    }

    @Override
    public List<Person> findParentsFor(int personId) {
        Person person = this.findPersonWithId(personId);
        List<Person> parents = new ArrayList<Person>();
        //here add blank if not found
        parents.add((Person)this.findPersonWithId(person.getFatherId()));
        parents.add((Person)this.findPersonWithId(person.getMotherId()));
        return parents;
    }

    @Override
    public List<Person> findSiblingsFor(int personId) {
        Person person = this.findPersonWithId(personId);
        List<Person> siblings = this.findChildrenForCouple(person.getFather(), person.getMother());
        if (siblings.size() > 0) {
            return siblings;
        } else {
            List<Person> personList = new ArrayList<Person>();
            personList.add(person);
            return personList;
        }
    }

    @Override
    public List<Person> findChildrenFor(Person father) {
        return (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.eq("father", father)).addOrder(Order.asc("birthDate")).list();
    }

    @Override
    public List<Person> findWivesFor(int personId) {
        Person person = this.findPersonWithId(personId);
        List<Person> children = (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.eq("father", person)).addOrder(Order.asc("birthDate")).list();
        List<Person> wives = new ArrayList<Person>();
        Set<Integer> wifeIds = new HashSet<Integer>();
        for (Person child : children) {
            if (child.getMotherId() != 0) {
                wifeIds.add(child.getMotherId());
            }
        }
        for (int wifeId : wifeIds) {
            Person wife = this.findPersonWithId(wifeId);
            wives.add(wife);
        }
        return wives;
    }

    @Override
    public List<Person> findChildrenForCouple(Person person, Person wife) {
        return (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.eq("father", person)).add(Restrictions.eq("mother", wife)).addOrder(Order.asc("birthDate")).list();
    }

    @Override
    public List<Person> findSpousesFor(int personId) {
        Person person = this.findPersonWithId(personId);
        List<Person> children;
        if (person.getGender()) {
            children = (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.eq("father", person)).addOrder(Order.asc("birthDate")).list();
        } else {
            children = (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.eq("mother", person)).addOrder(Order.asc("birthDate")).list();
        }
        List<Person> spouses = new ArrayList<Person>();
        List<Integer> spouseIds = new ArrayList<Integer>();
        for (Person child : children) {
            if (person.getGender()) {
                if (child.getMotherId() != 0) {
                    if (!spouseIds.contains(child.getMotherId())) {
                        spouseIds.add(child.getMotherId());
                    }
                }
            } else {
                if (child.getFatherId() != 0) {
                    if (!spouseIds.contains(child.getFatherId())) {
                        spouseIds.add(child.getFatherId());
                    }
                }
            }
        }
        for (int spouseId : spouseIds) {
            Person spouse = this.findPersonWithId(spouseId);
            spouses.add(spouse);
        }
        return spouses;
    }

    @Override
    public List<Person> findAllDescendentsOfPerson(int rootAncestorPersonId) {
        List<Integer> personIds = treeResolver.ids(rootAncestorPersonId);
        return (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.in("id", personIds)).list();
    }

    @Override
    public List<Person> findAllPersons(int personsPerPage) {
        return (List<Person>)currentSession().createCriteria(Person.class).addOrder(Order.asc("birthDate")).setMaxResults(personsPerPage).list();
    }

}
