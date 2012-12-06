package com.ethertons.web;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.easymock.EasyMock;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import com.ethertons.domain.Surname;

public class AddSurnameFormTest {

    private OnsService onsService;
    private AddSurnameForm addSurnameForm;
    private Model model;
    private BindingResult result;

    @Before
    public void setUp() throws Exception {
        onsService = EasyMock.createMock(OnsServiceImpl.class);
        addSurnameForm = new AddSurnameForm(onsService);
        model = EasyMock.createMock(Model.class);
        result = EasyMock.createMock(BindingResult.class);
    }

    @Test
    public void addNewSurnameFormShouldBeShown() throws Exception {

        EasyMock.expect(model.addAttribute(EasyMock.eq("surname"), EasyMock.anyObject(Surname.class))).andReturn(model);

        replay(onsService, model);
        String formName = addSurnameForm.setUpForm(model);
        verify(onsService, model);

        assertThat(formName, is("surnames/form"));
    }

    @Test
    public void processSubmitShouldCallStoreSurname() throws Exception {

        Surname surname = aNewSurname();

        expect(result.hasErrors()).andReturn(false);
        onsService.storeSurname(surname);

        replay(onsService, result);
        String showSurnameForm = addSurnameForm.processSubmit(surname, result);
        verify(onsService, result);

        assertThat(showSurnameForm, CoreMatchers.is("redirect:/surnames/6"));

    }

    private Surname aNewSurname() {
        Surname surname = new Surname();
        surname.setId(6);
        surname.setName("Smith");
        return surname;
    }
}
