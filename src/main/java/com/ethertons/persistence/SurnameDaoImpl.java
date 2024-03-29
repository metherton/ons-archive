package com.ethertons.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ethertons.domain.Surname;

@Repository
@Transactional
public class SurnameDaoImpl extends GenericDao implements SurnameDao {

    @Autowired
    public SurnameDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Surname> findAllSurnames() {
        return (List<Surname>)currentSession().createCriteria(Surname.class).list();
    }

    @Override
    public Surname findSurnameWith(int surnameId) {
        return (Surname)currentSession().get(Surname.class, surnameId);
    }

    @Override
    public void storeSurname(Surname surname) {
        currentSession().merge(surname);
    }
}
