package com.ethertons.persistence;

import java.util.List;

import com.ethertons.domain.Gedcom;

public interface GedcomDao {

    Gedcom findGedcomWith(int gedcomId);

    void storeGedcom(Gedcom gedcom);

    List<Gedcom> findAllGedcoms();

}
