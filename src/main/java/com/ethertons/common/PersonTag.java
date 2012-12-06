package com.ethertons.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ethertons.domain.Person;

public class PersonTag extends SimpleTagSupport {

    private List<Person> persons;

    public void doTag() throws IOException, JspException {
        Iterator i = persons.iterator();
        while (i.hasNext()) {
            Person person = (Person) i.next();
            getJspContext().setAttribute("person", person);
            getJspBody().invoke(null);
        }
    }
    
    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
}
