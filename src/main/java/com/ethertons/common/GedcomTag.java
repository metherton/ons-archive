package com.ethertons.common;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ethertons.domain.GedcomDetails;
import gedcom.GedcomIndividual;


public class GedcomTag extends SimpleTagSupport {

    private GedcomDetails gedcomDetails;

    public void doTag() throws IOException, JspException {
        List<GedcomIndividual> individuals = gedcomDetails.getGedcomParser().individuals();
        for(GedcomIndividual gedcomIndividual : individuals)  {
            getJspContext().setAttribute("gedcomIndividual", gedcomIndividual);
            getJspBody().invoke(null);
        }


    }

    public void setGedcomDetails(GedcomDetails gedcomDetails) {
        this.gedcomDetails = gedcomDetails;
    }

}
