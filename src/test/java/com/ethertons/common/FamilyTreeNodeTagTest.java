package com.ethertons.common;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.tagext.JspFragment;

import com.ethertons.domain.ImmediateFamily;
import com.ethertons.domain.Person;
import org.junit.Test;

public class FamilyTreeNodeTagTest {

    @Test
    public void shouldSetImmediateFamilyAttributeShouldBeSet() throws Exception {

        FamilyTreeNodeTag familyTreeNodeTag = new FamilyTreeNodeTag();

        ImmediateFamily immediateFamily = createMock(ImmediateFamily.class);
        familyTreeNodeTag.setImmediateFamily(immediateFamily);

        Person grandad = addPerson(1, "Grandad Etherton");
        Person nannan = addPerson(2, "Nannan Etherton");
        List<Person> grandparents = addPersons(grandad, nannan);

        expect(immediateFamily.getParents()).andReturn(grandparents);
        expect(immediateFamily.getSiblings()).andReturn(Collections.<Person>emptyList());
        expect(immediateFamily.getActivePersonId()).andStubReturn(1);
        expect(immediateFamily.findSiblingPosition(1)).andStubReturn(2);
        expect((immediateFamily.getSpouses())).andReturn(Collections.<Person>emptyList());
        expectLastCall().times(3);




        FamilyTreeNode grandadNode = new FamilyTreeNode.Spouse().left("0")
                                                                 .top("0")
                                                                 .id("1")
                                                                 .fullname("Grandad Etherton")
                                                                 .mLineDisplay("block")
                                                                 .mLineTop("3.8")
                                                                 .mLineLeft("12")
                                                                 .mLineWidth("4")
                                                                 .l1PlineDisplay("none")
                                                                 .l2PlineDisplay("none")
                                                                 .l3PlineDisplay("none")
                                                                 .build();

        FamilyTreeNode nannanNode = new FamilyTreeNode.Spouse().left("14")
                .top("0")
                .id("2")
                .fullname("Nannan Etherton")
                .l1PlineDisplay("none")
                .l2PlineDisplay("none")
                .l3PlineDisplay("none")
                .build();

        JspContext jspContext = createMock(JspContext.class);
        jspContext.setAttribute("familyTreeNode",grandadNode);
        jspContext.setAttribute("familyTreeNode",nannanNode);
        familyTreeNodeTag.setJspContext(jspContext);
        JspFragment jspBodyFragment =  createMock(JspFragment.class);
        jspBodyFragment.invoke(null);
        expectLastCall().times(2);
        familyTreeNodeTag.setJspBody(jspBodyFragment);

        replay(jspBodyFragment, jspContext, immediateFamily);
        familyTreeNodeTag.doTag();
        verify(jspBodyFragment, jspContext, immediateFamily);

    }

    private List<Person> addPersons(Person person1, Person person2) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);
        return persons;
    }

    private Person addPerson(int id, String fullname) {
        Person person = new Person();
        person.setId(id);
        person.setFullname(fullname);
        return person;
    }

}
