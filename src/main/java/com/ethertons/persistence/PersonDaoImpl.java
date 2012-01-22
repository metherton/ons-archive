package com.ethertons.persistence;

import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
