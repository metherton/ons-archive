package com.ethertons.common;

import gedcom.GedcomIndividual;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ethertons.domain.GedcomDetails;

@Service
public class GedcomRetriever {

    @Value("${gedcomfiles.directory}")
    public String gedcomfilesDirectory;

    public GedcomDetails retrieveGedcom(int gedcomId) {

        return new GedcomDetails(gedcomfilesDirectory + gedcomId +".ged");
    }

    public List<GedcomIndividual> retrieveGedcomIndividuals(int gedcomId) {
        GedcomDetails gedcomDetails = new GedcomDetails(gedcomfilesDirectory + gedcomId +".ged");
        return gedcomDetails.getGedcomParser().individuals();
    }
}
