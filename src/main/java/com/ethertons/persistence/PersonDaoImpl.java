package com.ethertons.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ethertons.domain.Person;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDaoImpl extends GenericDao implements PersonDao {

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Person findPersonWith(int personId) {
        return (Person)currentSession().get(Person.class, personId);
    }

    @Override
    public void storePerson(Person person) {
        currentSession().merge(person);
    }

    @Override
    public List<Person> findAllMalePersons() {
        return (List<Person>)currentSession().createCriteria(Person.class).
                                                add(Restrictions.eq("gender", true)).
                                                list();
    }

    @Override
    public List<Person> findAllFemalePersons() {
        return (List<Person>)currentSession().createCriteria(Person.class).
                add(Restrictions.eq("gender", false)).
                list();
    }

    @Override
    public List<Person> findAllPersons() {
        return (List<Person>)currentSession().createCriteria(Person.class).list();
    }

    @Override
    public List<Person> findParentsFor(int personId) {
        Person person = this.findPersonWith(personId);
        List<Person> parents = new ArrayList<Person>();
        parents.add((Person)this.findPersonWith(person.getFather().getId()));
        parents.add((Person)this.findPersonWith(person.getMother().getId()));
        return parents;
    }

    @Override
    public List<Person> findSiblingsFor(int personId) {
        Person person = this.findPersonWith(personId);
        List<Person> siblings = this.findChildrenFor(person.getFather());
        return siblings;
    }

    @Override
    public List<Person> findChildrenFor(Person father) {
        return (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.eq("father", father)).list();
    }

}
