package com.ethertons.common;

import com.ethertons.domain.GedcomDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GedcomRetriever {

    @Value("${gedcomfiles.directory}")
    public String gedcomfilesDirectory;

    public GedcomDetails retrieveGedcom(int gedcomId) {

        return new GedcomDetails(gedcomfilesDirectory + gedcomId +".ged");
    }
}
