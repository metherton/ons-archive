package com.ethertons.web;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Ignore;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;

@Ignore
public class FormTest {

    protected OnsService onsService;
    protected Model model;
    protected AddPersonForm addPersonForm;
    protected BindingResult result;

    @Before
    public void setUpForm() throws Exception {
        onsService = EasyMock.createMock(OnsServiceImpl.class);
        model = EasyMock.createMock(Model.class);
        result = EasyMock.createMock(BindingResult.class);
    }

}
