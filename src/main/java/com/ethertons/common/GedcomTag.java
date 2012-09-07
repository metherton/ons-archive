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
//        gedcomDetails = new GedcomDetails();
//        Iterator iterator = (Iterator) gedcomDetails.getGedcomParser().individuals();
////        Iterator iterator = (Iterator) gedcomDetails.getGedcomParser().individuals();
//        while (iterator.hasNext()) {
//            GedcomIndividual gedcomIndividual = (GedcomIndividual) iterator.next();
//            getJspContext().setAttribute("gedcomIndividual", gedcomIndividual);
//            getJspBody().invoke(null);
//        }

        gedcomDetails = new GedcomDetails();
        List<GedcomIndividual> individuals = gedcomDetails.getGedcomParser().individuals();
//        Iterator iterator = (Iterator) gedcomDetails.getGedcomParser().individuals();
//        while (iterator.hasNext()) {
        for(GedcomIndividual gedcomIndividual : individuals)  {
//            GedcomIndividual gedcomIndividual = (GedcomIndividual) iterator.next();
            getJspContext().setAttribute("gedcomIndividual", gedcomIndividual);
            getJspBody().invoke(null);
        }


    }

    public void setGedcomDetails(GedcomDetails gedcomDetails) {
        this.gedcomDetails = gedcomDetails;
    }

}
