package com.ethertons.persistence;

import java.util.List;

import com.ethertons.domain.Surname;

public interface SurnameDao {
    List<Surname> findAllSurnames();

    Surname findSurnameWith(int surnameId);

    void storeSurname(Surname surname);
}
