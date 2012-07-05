package com.ethertons.common;

import static com.ethertons.common.FamilyTreeNodeConverter.*;
import static com.ethertons.common.FamilyTreeNodeTag.AfterActivePersonOffset.*;
import static com.ethertons.common.FamilyTreeNodeTag.AfterActivePersonWifeOffset.*;
import static java.lang.String.format;

import java.io.IOException;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ethertons.domain.ImmediateFamily;
import com.ethertons.domain.Person;

public class FamilyTreeNodeTag extends SimpleTagSupport {

    private static final int FAMILY_NODE_WIDTH_EM = 14;
    private ImmediateFamily immediateFamily;

    public void doTag() throws IOException, JspException {
        renderParentNodes();
        renderSiblings();
        renderSpousesAndChildren();
    }


    private void convertSpouseAndChildren(int spouseNumber, Person spouse, int afterActivePersonOffset, int activePersonPosition) throws JspException, IOException {
        FamilyTreeNode spouseFamilyFamilyTreeNode = new FamilyTreeNode.Builder().build();
        if (spouseNumber == 1) {
            spouseFamilyFamilyTreeNode.setLeft(String.format("%d", (activePersonPosition + spouseNumber) * FAMILY_NODE_WIDTH_EM));
            spouseFamilyFamilyTreeNode.setTop("8");
            spouseFamilyFamilyTreeNode.setId(format("%d", spouse.getId()));
            spouseFamilyFamilyTreeNode.setFullname(spouse.getFullname());
            spouseFamilyFamilyTreeNode.setMlineDisplay("block");
            spouseFamilyFamilyTreeNode.setMlineLeft("-2");
            spouseFamilyFamilyTreeNode.setMlineWidth("4");
            spouseFamilyFamilyTreeNode.setMlineTop("3.8");
            spouseFamilyFamilyTreeNode.setL1PlineDisplay("none");
            spouseFamilyFamilyTreeNode.setL3PlineDisplay("none");

            getJspContext().setAttribute("familyTreeNode", spouseFamilyFamilyTreeNode);
            getJspBody().invoke(null);

            Iterator children = immediateFamily.getChildrenWithWife(spouse.getId()).iterator();


            int childCount = 1;

            while (children.hasNext()) {
                Person child = (Person) children.next();
                FamilyTreeNode familyTreeNodeChild = new FamilyTreeNode.Builder().left(String.format("%d", (activePersonPosition + (childCount-1)) * FAMILY_NODE_WIDTH_EM))
                                                                                 .top("16")
                                                                                 .id(format("%d", child.getId()))
                                                                                 .fullname(child.getFullname())
                                                                                 .mLineDisplay("none").build();

                if (childCount == 1) {
                    familyTreeNodeChild.setL1PlineLeft("100");
                    familyTreeNodeChild.setL2PlineWidth("50");
                    familyTreeNodeChild.setL1PlineLeft("100");
                    familyTreeNodeChild.setL2PlineLeft("50");
                } else {
                    familyTreeNodeChild.setL1PlineDisplay("none");
                    familyTreeNodeChild.setL2PlineWidth(String.format("%d",50 + (childCount-2)*100));
                    familyTreeNodeChild.setL2PlineLeft(String.format("%d",0 - (childCount-2)*100));
                }

                getJspContext().setAttribute("familyTreeNode", familyTreeNodeChild);
                getJspBody().invoke(null);


                childCount++;

            }




        } else {

            spouseFamilyFamilyTreeNode.setLeft(String.format("%d",
                    (activePersonPosition + spouseNumber + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM));
            spouseFamilyFamilyTreeNode.setTop("8");
            spouseFamilyFamilyTreeNode.setId(format("%d", spouse.getId()));
            spouseFamilyFamilyTreeNode.setFullname(spouse.getFullname());

            spouseFamilyFamilyTreeNode.setMlineDisplay("block");
            spouseFamilyFamilyTreeNode.setMlineLeft(String.format("-%d", ((activePersonPosition + spouseNumber + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM) - (((activePersonPosition + spouseNumber - 1) * 14) + 12)));
            spouseFamilyFamilyTreeNode.setMlineWidth(String.format("%d", ((activePersonPosition + spouseNumber + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM) - ((activePersonPosition + spouseNumber - 1) * 14) - 10));
            spouseFamilyFamilyTreeNode.setMlineTop("3.8");
            spouseFamilyFamilyTreeNode.setL1PlineDisplay("none");
            spouseFamilyFamilyTreeNode.setL3PlineDisplay("none");

            getJspContext().setAttribute("familyTreeNode", spouseFamilyFamilyTreeNode);
            getJspBody().invoke(null);

            Iterator children = immediateFamily.getChildrenWithWife(spouse.getId()).iterator();


            int childCount = 1;

            while (children.hasNext()) {
                Person child = (Person) children.next();
                FamilyTreeNode familyTreeNodeChild = new FamilyTreeNode.Builder().build();
                familyTreeNodeChild.setLeft(String.format("%d", (activePersonPosition + spouseNumber + afterActivePersonOffset + childCount-1) * FAMILY_NODE_WIDTH_EM));
                familyTreeNodeChild.setTop("16");
                familyTreeNodeChild.setId(format("%d", child.getId()));
                familyTreeNodeChild.setFullname(child.getFullname());
                familyTreeNodeChild.setMlineDisplay("none");

                if (childCount == 1) {
                    familyTreeNodeChild.setL1PlineDisplay("block");
                }   else {
                    familyTreeNodeChild.setL1PlineDisplay("none");
                }
                familyTreeNodeChild.setL2PlineWidth(String.format("%d",50 + (childCount-1)*100));
                familyTreeNodeChild.setL2PlineLeft(String.format("%d",0 - (childCount-1)*100));

                getJspContext().setAttribute("familyTreeNode", familyTreeNodeChild);
                getJspBody().invoke(null);


                childCount++;
            }

        }
    }

    private void renderSiblings() throws JspException, IOException {
        Iterator siblings = immediateFamily.getSiblings().iterator();
        int siblingCount = 0;
        int activePersonPosition = immediateFamily.findSiblingPosition(immediateFamily.getActivePersonId());
        int afterActivePersonOffset = calculate(immediateFamily);
        while (siblings.hasNext()) {
            Person person = (Person) siblings.next();
            getJspContext().setAttribute("familyTreeNode", convertSibling(siblingCount, person, activePersonPosition, afterActivePersonOffset));
            getJspBody().invoke(null);
            siblingCount++;
        }
    }

    private void renderParentNodes() throws JspException, IOException {

        Iterator parents = immediateFamily.getParents().iterator();
        int parentCount = 0;
        while (parents.hasNext()) {
            Person person = (Person) parents.next();
            getJspContext().setAttribute("familyTreeNode", convertParent(parentCount, person));
            getJspBody().invoke(null);
            parentCount++;
        }
    }

    private void renderSpousesAndChildren() throws JspException, IOException {
        Iterator spouses = immediateFamily.getSpouses().iterator();
        int spouseNumber = 1;

        while (spouses.hasNext()) {
            Person spouse = (Person) spouses.next();

            int afterActivePersonOffset = calculate(immediateFamily, spouseNumber);

            int activePersonPosition = immediateFamily.findSiblingPosition(immediateFamily.getActivePersonId());

            convertSpouseAndChildren(spouseNumber, spouse, afterActivePersonOffset, activePersonPosition);
            spouseNumber++;
        }
    }

    public static class AfterActivePersonOffset {

        public static int calculate(ImmediateFamily immediateFamily) {
            int offset = immediateFamily.getSpouses().size();
            Iterator spouses = immediateFamily.getSpouses().iterator();
            int spouseCount = 0;
            while (spouses.hasNext()) {
                Person wife = (Person) spouses.next();
                int numberOfChildren = immediateFamily.getChildrenWithWife(wife.getId()).size();
                if (numberOfChildren > 2) {
                    if (spouseCount == 0) {
                        offset += numberOfChildren - 2;
                    } else {
                        offset += numberOfChildren - 1;
                    }
                } else if (numberOfChildren > 1 && spouseCount > 0 ) {
                    offset += numberOfChildren - 1;
                }
                spouseCount++;
            }
            return offset;
        }
    }

    public static class AfterActivePersonWifeOffset {

        public static int calculate(ImmediateFamily immediateFamily, int wifePosition) {
            if (wifePosition == 1) {
                return 0;
            }
            int offset = 0;
            Iterator spouses = immediateFamily.getSpouses().iterator();
            int spouseCount = 1;
            while (spouses.hasNext()) {
                if (spouseCount == wifePosition) {
                    return offset;
                }
                
                Person wife = (Person) spouses.next();
                int numberOfChildren = immediateFamily.getChildrenWithWife(wife.getId()).size();
                if (numberOfChildren > 2) {
                    if (spouseCount == 1) {
                        offset += numberOfChildren - 2;
                    } else {
                        offset += numberOfChildren - 1;
                    }
                }
                spouseCount++;
            }
            return offset;
        }
    }

    public void setImmediateFamily(ImmediateFamily immediateFamily) {
        this.immediateFamily = immediateFamily;
    }

}
