package com.ethertons.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ethertons.common.FileHandler;
import com.ethertons.domain.Gedcom;
import com.ethertons.domain.OnsService;

@Controller
@SessionAttributes("gedcom")
@RequestMapping("/gedcoms/new")
public class AddGedcomForm extends OnsForm {

    public static final String GEDCOMS_FORM = "gedcoms/form";

    @Value("${gedcomfiles.directory}")
    public String gedcomfilesDirectory;

    private FileHandler fileHandler;

    @Autowired
    public AddGedcomForm(OnsService onsService, FileHandler fileHandler) {
        super(onsService);
        this.fileHandler = fileHandler;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("gedcom") @Valid Gedcom gedcom, BindingResult result, @RequestParam(value="gedcomfile",required=false) MultipartFile gedcomfile) {
        if (result.hasErrors()) {
            return GEDCOMS_FORM;
        } else {
            this.onsService.storeGedcom(gedcom);
        }
        if(!gedcomfile.isEmpty()){
            validateImage(gedcomfile);
            String fileName = gedcomfilesDirectory + gedcom.getId()+".ged";
            fileHandler.save(fileName,gedcomfile);//
        }
        return "redirect:/gedcoms/" + gedcom.getId();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setUpForm(Model model) {
        Gedcom gedcom = new Gedcom();
        model.addAttribute("gedcom", gedcom);
        return GEDCOMS_FORM;
    }

    private void validateImage(MultipartFile gedcomFile){
        return;
    }

    private void saveGedcomFile(String filename, MultipartFile gedcomfile) throws GedcomUploadException {
        try {
            File file=new File(filename);
            FileUtils.writeByteArrayToFile(file, gedcomfile.getBytes());
        } catch(IOException e){
            throw new GedcomUploadException("Unabletosavegedcomfile",e);
        }
    }

    private class GedcomUploadException extends RuntimeException {
        public GedcomUploadException(String unabletosavegedcomfile, IOException e) {
        }
    }
}
