package com.ethertons.domain;

import gedcom.GedcomParser;

public class GedcomDetails {

    private GedcomParser gedcomParser;

    public GedcomDetails(String gedcomFileName) {
        gedcomParser = new GedcomParser(gedcomFileName);
    }

    public GedcomParser getGedcomParser() {
        return gedcomParser;
    }
}
