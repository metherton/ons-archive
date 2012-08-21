package com.ethertons.persistence;

import java.util.List;

import com.ethertons.domain.Gedcom;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GedcomDaoImpl  extends GenericDao  implements GedcomDao {

    @Autowired
    public GedcomDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Gedcom findGedcomWith(int gedcomId) {
        return (Gedcom)currentSession().get(Gedcom.class, gedcomId);
    }

    @Override
    public void storeGedcom(Gedcom gedcom) {
        currentSession().merge(gedcom);
    }

    @Override
    public List<Gedcom> findAllGedcoms() {
        return (List<Gedcom>)currentSession().createCriteria(Gedcom.class).list();
    }
}
