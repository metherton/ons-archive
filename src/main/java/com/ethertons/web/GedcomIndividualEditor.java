package com.ethertons.web;

import gedcom.GedcomIndividual;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

public class GedcomIndividualEditor  extends PropertyEditorSupport {

    public GedcomIndividualEditor() {
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isBlank(text)) {
            return;
        } else {
            GedcomIndividual gedcomIndividual = new GedcomIndividual("","","","",text,"");
            setValue(gedcomIndividual);
        }
    }

    @Override
    public String getAsText() {
        GedcomIndividual gedcomIndividual = (GedcomIndividual) getValue();
        if (gedcomIndividual == null) {
            return null;
        } else {
            return gedcomIndividual.getId();
        }
    }

}
