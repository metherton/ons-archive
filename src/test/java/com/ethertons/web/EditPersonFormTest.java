package com.ethertons.web;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.ethertons.domain.Person;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

public class EditPersonFormTest extends FormTest {

    private EditPersonForm editPersonForm;

    @Before
    public void setUp() throws Exception {
        editPersonForm = new EditPersonForm(onsService);
    }

    @Test
    public void editPersonFormShouldBeShown() throws Exception {
        Person person = new Person();
        
        EasyMock.expect(onsService.findPersonWith(1)).andReturn(person);
        EasyMock.expect(model.addAttribute("person", person)).andReturn(model);

        EasyMock.replay(onsService, model);
        String formName = editPersonForm.setUpForm(1, model);
        EasyMock.verify(onsService, model);
        assertThat(formName, is("persons/form"));
        
    }
}
