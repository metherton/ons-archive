package com.ethertons.persistence;

import com.ethertons.domain.Config;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ConfigDaoImpl extends GenericDao implements ConfigDao{


    private static final int WEBMASTER_ID = 1;

    @Autowired
    public ConfigDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public String findAuthor() {
        Config config = (Config)currentSession().get(Config.class, WEBMASTER_ID);
        return config.getValue();
    }

}
