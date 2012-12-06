package com.ethertons.web;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Surname;

public class SurnameEditor extends PropertyEditorSupport {

    private final OnsService onsService;

    public SurnameEditor(OnsService onsService) {
        this.onsService = onsService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isBlank(text)) {
            return;
        } else {
            Surname surname = onsService.findSurnameWith((int) Integer.parseInt(text));
            setValue(surname);
        }
    }

    @Override
    public String getAsText() {
        Surname surname = (Surname) getValue();
        if (surname == null) {
            return null;
        } else {
            return Integer.toString(surname.getId());
        }
    }

}
