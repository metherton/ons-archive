package com.ethertons.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDao {

    protected final SessionFactory sessionFactory;

    public GenericDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
