package com.ethertons.web;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddPersonFormTest {

    @Test
    public void addNewPersonFormShouldBeShown() {

        OnsService onsService = EasyMock.createMock(OnsServiceImpl.class);
        Model model = EasyMock.createMock(Model.class);
        AddPersonForm addPersonForm = new AddPersonForm(onsService);

        List<Surname> possibleSurnames = new ArrayList<Surname>();
        possibleSurnames.add(new Surname());
        possibleSurnames.add(new Surname());

        expect(onsService.findAllSurnames()).andReturn(possibleSurnames);
        expect(model.addAttribute(EasyMock.eq("person"), EasyMock.anyObject(Person.class))).andReturn(model);

        replay(onsService, model);
        String formName = addPersonForm.setUpForm(model);
        verify(onsService, model);
        
        assertThat(formName, is("persons/form"));
        
    }

    @Test
    public void processSubmitShouldCallStorePerson() throws Exception {

        OnsService onsService = EasyMock.createMock(OnsService.class);
        BindingResult result = EasyMock.createMock(BindingResult.class);
        
        Person person = new Person();
        Surname surname = new Surname();
        surname.setId(6);
        surname.setName("Smith");
        person.setId(5);
        person.setFirstName("Johnny");
        person.setSurname(surname);

        AddPersonForm addPersonForm = new AddPersonForm(onsService);

        expect(result.hasErrors()).andReturn(false);
        onsService.storePerson(person);

        replay(onsService, result);
        String showPersonForm = addPersonForm.processSubmit(person, result);
        verify(onsService, result);
        
        assertThat(showPersonForm, is("redirect:/persons/5"));
    }
}
