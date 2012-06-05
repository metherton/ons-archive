package com.ethertons.common;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
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

        FamilyTreeNode familyTreeNode = new FamilyTreeNode.Wife().build();

        JspContext jspContext = createMock(JspContext.class);
        jspContext.setAttribute("familyTreeNode", familyTreeNode);
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
