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
        //here add blank if not found
        parents.add((Person)this.findPersonWith(person.getFatherId()));
        parents.add((Person)this.findPersonWith(person.getMotherId()));
        return parents;
    }

    @Override
    public List<Person> findSiblingsFor(int personId) {
        Person person = this.findPersonWith(personId);
        List<Person> siblings = this.findChildrenFor(person.getFather());
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
        return (List<Person>)currentSession().createCriteria(Person.class).add(Restrictions.eq("father", father)).list();
    }

}
