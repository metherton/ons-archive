package com.ethertons.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.tagext.JspFragment;

import org.easymock.EasyMock;
import org.junit.Test;

import com.ethertons.domain.Person;

public class PersonTagTest1 {


    @Test
    public void personDetailAttributesShouldBeSet() throws Exception {

        PersonTag personTag = new PersonTag();

        Person person1 = addPerson(1, "Martin Etherton");
        Person person2 = addPerson(2, "Martin Etherton2");

        List<Person> persons = addPersons(person1, person2);

        personTag.setPersons(persons);

        JspContext jspContext = EasyMock.createMock(JspContext.class);
        jspContext.setAttribute("person", person1);
        jspContext.setAttribute("person", person2);
        personTag.setJspContext(jspContext);
        JspFragment jspBodyFragment =  EasyMock.createMock(JspFragment.class);
        jspBodyFragment.invoke(null);
        EasyMock.expectLastCall().times(2);
        personTag.setJspBody(jspBodyFragment);

        EasyMock.replay(jspBodyFragment, jspContext);
        personTag.doTag();
        EasyMock.verify(jspBodyFragment, jspContext);

    }

    private List<Person> addPersons(Person person1, Person person2) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        return persons;
    }

    private Person addPerson(int id, String fullname) {
        Person person = new Person();
        person.setId(id);
        person.setFullname(fullname);
        return person;
    }


}
