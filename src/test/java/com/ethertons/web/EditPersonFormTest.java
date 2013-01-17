package com.ethertons.web;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.ethertons.domain.Person;

public class EditPersonFormTest extends FormTest {

    private EditPersonForm editPersonForm;

    @Before
    public void setUp() throws Exception {
        editPersonForm = new EditPersonForm(onsService);
    }

    @Test
    public void editPersonFormShouldBeShown() throws Exception {
        Person person = new Person();
        
        expect(onsService.findPersonWith(1)).andReturn(person);
        expect(model.addAttribute("person", person)).andReturn(model);

        replay(onsService, model);
        String formName = editPersonForm.setUpForm(1, model);
        verify(onsService, model);
        assertThat(formName, is("persons/form"));
        
    }
}
