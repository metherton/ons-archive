package com.ethertons.web;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import com.ethertons.common.FileHandler;
import com.ethertons.domain.Gedcom;
import com.ethertons.domain.OnsService;
import com.ethertons.domain.OnsServiceImpl;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

public class AddGedcomFormTest {

    private OnsService onsService;
    private FileHandler fileHandler;
    private AddGedcomForm addGedcomForm;
    private Model model;
    private BindingResult result;
    private MultipartFile file;

    @Before
    public void setUp() {
        fileHandler = EasyMock.createMock(FileHandler.class);
        onsService = EasyMock.createMock(OnsServiceImpl.class);
        addGedcomForm = new AddGedcomForm(onsService, fileHandler);
        model = EasyMock.createMock(Model.class);
        result = EasyMock.createMock(BindingResult.class);
        file = EasyMock.createMock(MultipartFile.class);
    }

    @Test
    public void addGedcomFormShouldBeShown() {

        expect(model.addAttribute(eq("gedcom"), anyObject(Gedcom.class))).andReturn(model);

        replay(onsService, model);
        String formName = addGedcomForm.setUpForm(model);
        verify(onsService, model);

        assertThat(formName, is("gedcoms/form"));
    }

    @Test
    public void processSubmitShouldCallStoreGedcom() throws Exception {

        Gedcom gedcom = new Gedcom();
        gedcom.setId(1);
        gedcom.setTitle("gedcom 1");

        expect(result.hasErrors()).andReturn(false);
        onsService.storeGedcom(gedcom);
        fileHandler.save("", file);

        replay(onsService, result);
        String showGedcomForm = addGedcomForm.processSubmit(gedcom, result, file);
        verify(onsService, result);

        assertThat(showGedcomForm, is("redirect:/gedcoms/1"));

    }


}
