package com.ethertons.persistence;

import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SurnameDaoImpl implements SurnameDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public SurnameDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Surname> findAllSurnames() {
        return (List<Surname>)currentSession().createCriteria(Surname.class).list();
    }

    @Override
    public Surname findSurnameWith(int surnameId) {
        return (Surname)currentSession().get(Surname.class, surnameId);
    }
}
