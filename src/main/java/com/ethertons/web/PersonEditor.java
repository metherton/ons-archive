package com.ethertons.web;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Person;

public class PersonEditor  extends PropertyEditorSupport {
    
    private final OnsService onsService;

    public PersonEditor(OnsService onsService) {
        this.onsService = onsService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isBlank(text)) {
            return;
        } else {
            Person person = onsService.findPersonWith((int) Integer.parseInt(text));
            setValue(person);
        }
    }

    @Override
    public String getAsText() {
        Person person = (Person) getValue();
        if (person == null) {
            return null;
        } else {
            return Integer.toString(person.getId());
        }
    }
    
    
}
