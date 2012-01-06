package com.ethertons.web;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Surname;

import java.beans.PropertyEditorSupport;

    public class SurnameEditor extends PropertyEditorSupport {

    private final OnsService onsService;

    public SurnameEditor(OnsService onsService) {
        this.onsService = onsService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Surname surname = onsService.findSurnameWith((int) Integer.parseInt(text));
        System.out.println(text);
        System.out.println("getname");
        System.out.println(surname.getName());
        System.out.println("gotot");
        setValue(surname);
    }

    @Override
    public String getAsText() {
        Surname s = (Surname) getValue();
        if (s == null) {
            return null;
        } else {
            return Integer.toString(s.getId());
        }
    }

}
