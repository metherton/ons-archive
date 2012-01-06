package com.ethertons.domain;

import java.util.List;

public interface OnsService {
    public String findWebMaster();

    Person findPersonWith(int personId);

    List<Surname> findAllSurnames();

    void storePerson(Person person);

    Surname findSurnameWith(int surnameId);
}
