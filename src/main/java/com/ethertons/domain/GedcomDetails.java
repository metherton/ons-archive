package com.ethertons.domain;

import gedcom.GedcomParser;

public class GedcomDetails {

    private GedcomParser gedcomParser;

    public GedcomDetails() {
        gedcomParser = new GedcomParser("/Users/metherton/Downloads/EthertonLondon.ged");
    }

    public GedcomParser getGedcomParser() {
        return gedcomParser;
    }
}
