package com.ethertons.domain;

import com.ethertons.persistence.ConfigDao;
import com.ethertons.persistence.PersonDao;
import com.ethertons.persistence.SurnameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnsServiceImpl implements OnsService {

    private final PersonDao personDao;
    private final ConfigDao configDao;
    private final SurnameDao surnameDao;

    @Autowired
    public OnsServiceImpl(PersonDao personDao, ConfigDao configDao, SurnameDao surnameDao) {
        this.personDao = personDao;
        this.configDao = configDao;
        this.surnameDao = surnameDao;
    }


    @Override
    public String findWebMaster() {
        return configDao.findAuthor();
    }

    @Override
    public Person findPersonWith(int personId) {
        return personDao.findPersonWith(personId);
    }

    @Override
    public Surname findSurnameWith(int surnameId) {
        return surnameDao.findSurnameWith(surnameId);
    }

    @Override
    public List<Surname> findAllSurnames() {
        return surnameDao.findAllSurnames();
    }

    @Override
    public void storePerson(Person person) {
        personDao.storePerson(person);
    }
}
