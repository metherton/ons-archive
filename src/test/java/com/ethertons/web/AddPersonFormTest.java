package com.ethertons.web;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;

public class AddPersonFormTest extends FormTest {

    @Before
    public void setUp() throws Exception {
        addPersonForm = new AddPersonForm(onsService);
    }

    @Test
    public void addNewPersonFormShouldBeShown() {

        expect(model.addAttribute(EasyMock.eq("person"), EasyMock.anyObject(Person.class))).andReturn(model);
        
        replay(onsService, model);
        String formName = addPersonForm.setUpForm(model);
        verify(onsService, model);
        
        assertThat(formName, is("persons/form"));
        
    }

    private List<Surname> possibleSurnames() {
        List<Surname> possibleSurnames = new ArrayList<Surname>();
        possibleSurnames.add(new Surname());
        possibleSurnames.add(new Surname());
        return possibleSurnames;
    }

    @Test
    public void processSubmitShouldCallStorePerson() throws Exception {

        Person person = aNewPerson();
        expect(result.hasErrors()).andReturn(false);
        onsService.storePerson(person);

        replay(onsService, result);
        String showPersonForm = addPersonForm.processSubmit(person, result);
        verify(onsService, result);
        
        assertThat(showPersonForm, is("redirect:/persons/5"));
    }

    private Person aNewPerson() {
        Person person = new Person();
        Surname surname = new Surname();
        surname.setId(6);
        surname.setName("Smith");
        person.setId(5);
        person.setFirstName("Johnny");
        person.setSurname(surname);
        person.setGender(true);
        return person;
    }
}
