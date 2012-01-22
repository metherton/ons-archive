package com.ethertons.persistence;

import com.ethertons.domain.Surname;

import java.util.List;

public interface SurnameDao {
    List<Surname> findAllSurnames();

    Surname findSurnameWith(int surnameId);

    void storeSurname(Surname surname);
}
