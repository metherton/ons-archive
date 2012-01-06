package com.ethertons.persistence;

import com.ethertons.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Person findPersonWith(int personId) {
        return (Person)currentSession().get(Person.class, personId);
    }

    @Override
    public void storePerson(Person person) {
        currentSession().merge(person);
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
