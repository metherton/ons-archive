package com.ethertons.web;

import gedcom.GedcomIndividual;

import org.springframework.stereotype.Component;

@Component
public class ViewGedcomForm {

    public GedcomIndividual getGedcomIndividual() {
        return gedcomIndividual;
    }


    public void setGedcomIndividual(GedcomIndividual gedcomIndividual) {
        this.gedcomIndividual = gedcomIndividual;
    }

    public String getTree() {
        return tree;
    }

    public void setTree(String tree) {
        this.tree = tree;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    private GedcomIndividual gedcomIndividual;
    private String tree;
    private String relation;
    private String person;


}
