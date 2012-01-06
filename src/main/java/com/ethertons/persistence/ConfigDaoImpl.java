package com.ethertons.persistence;

import com.ethertons.domain.Config;
import com.ethertons.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ConfigDaoImpl implements ConfigDao{

    private final SessionFactory sessionFactory;
    private static final int WEBMASTER_ID = 1;

    @Autowired
    public ConfigDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String findAuthor() {
        Config config = (Config)currentSession().get(Config.class, WEBMASTER_ID);
        return config.getValue();
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

}
