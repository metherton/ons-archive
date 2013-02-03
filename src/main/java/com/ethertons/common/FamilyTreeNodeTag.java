package com.ethertons.common;

import static com.ethertons.common.FamilyTreeNode.FAMILY_NODE_VERTICAL_SPACE_EM;
import static com.ethertons.common.FamilyTreeNode.FAMILY_NODE_WIDTH_EM;
import static com.ethertons.common.FamilyTreeNode.NODE_HEIGHT;
import static com.ethertons.common.FamilyTreeNode.NODE_PADDING_BOTTOM;
import static com.ethertons.common.FamilyTreeNode.NODE_PADDING_LEFT;
import static com.ethertons.common.FamilyTreeNode.NODE_PADDING_RIGHT;
import static com.ethertons.common.FamilyTreeNode.NODE_PADDING_TOP;
import static com.ethertons.common.FamilyTreeNode.NODE_WIDTH;
import static com.ethertons.common.FamilyTreeNode.SECOND_GENERATION_TOP;
import static com.ethertons.common.FamilyTreeNode.WIDTH_LESS_ONE_PADDING;
import static com.ethertons.common.FamilyTreeNodeConverter.convertParent;
import static com.ethertons.common.FamilyTreeNodeConverter.convertSibling;
import static com.ethertons.common.FamilyTreeNodeTag.AfterActivePersonOffset.calculate;
import static com.ethertons.common.FamilyTreeNodeTag.AfterActivePersonWifeOffset.calculate;
import static java.lang.String.format;
import static java.lang.String.valueOf;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.ethertons.domain.ImmediateFamily;
import com.ethertons.domain.Person;

public class FamilyTreeNodeTag extends SimpleTagSupport {

    private ImmediateFamily immediateFamily;
    private static DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM);
    
    
    public void doTag() throws IOException, JspException {
        renderParentNodes();
        renderSiblings();
        renderSpousesAndChildren();
    }

    private void convertSpouseAndChildren(int spouseNumber, Person spouse, int afterActivePersonOffset, int activePersonPosition) throws JspException, IOException {
        FamilyTreeNode spouseFamilyFamilyTreeNode = new FamilyTreeNode.Builder().paddingTop(valueOf(NODE_PADDING_TOP))
                                                                                .paddingBottom(valueOf(NODE_PADDING_BOTTOM))
                                                                                .paddingLeft(valueOf(NODE_PADDING_LEFT))
                                                                                .paddingRight(valueOf(NODE_PADDING_RIGHT))
                                                                                .top(valueOf(SECOND_GENERATION_TOP))
                                                                                .mLineDisplay("block")
                                                                                .id(format("%d", spouse.getId()))
                                                                                .fullname(spouse.getFullname())
                                                                                .birthDate(birthDate(spouse))
                                                                                .mLineTop(valueOf(NODE_PADDING_TOP + NODE_HEIGHT / 2))
                                                                                .l1PlineDisplay("none")
                                                                                .l3PlineDisplay("none")
                                                                                .build();   
        if (spouseNumber == 1) {
            spouseFamilyFamilyTreeNode.setLeft(String.format("%d", (activePersonPosition + spouseNumber) * FAMILY_NODE_WIDTH_EM));
            spouseFamilyFamilyTreeNode.setMlineLeft("-" + String.valueOf(NODE_PADDING_LEFT));
            spouseFamilyFamilyTreeNode.setMlineWidth(String.valueOf(NODE_PADDING_LEFT + NODE_PADDING_RIGHT));
            getJspContext().setAttribute("familyTreeNode", spouseFamilyFamilyTreeNode);
            getJspBody().invoke(null);
            Iterator children = immediateFamily.getChildrenWithWife(spouse.getId()).iterator();
            int childCount = 1;
            while (children.hasNext()) {
                Person child = (Person) children.next();
                FamilyTreeNode familyTreeNodeChild = new FamilyTreeNode.Builder().left(String.format("%d", (activePersonPosition + (childCount-1)) * FamilyTreeNode.FAMILY_NODE_WIDTH_EM))
                                                                                 .top(String.valueOf(FamilyTreeNode.THIRD_GENERATION_TOP))
                                                                                 .id(format("%d", child.getId()))
                                                                                 .fullname(child.getFullname())
                                                                                 .birthDate(birthDate(child))
                                                                                 .location(child.getAddress())
                                                                                 .mLineDisplay("none").build();

                familyTreeNodeChild.setPaddingTop(valueOf(NODE_PADDING_TOP));
                familyTreeNodeChild.setPaddingBottom(valueOf(NODE_PADDING_BOTTOM));
                familyTreeNodeChild.setPaddingLeft(valueOf(NODE_PADDING_LEFT));
                familyTreeNodeChild.setPaddingRight(valueOf(NODE_PADDING_RIGHT));                 
                
                familyTreeNodeChild.setL1PlineTop(String.valueOf(FAMILY_NODE_VERTICAL_SPACE_EM / 2 + (NODE_HEIGHT / 2)));                
                
                if (childCount == 1) {
                    familyTreeNodeChild.setL1PlineLeft("100");
                    familyTreeNodeChild.setL2PlineWidth("50");
                    familyTreeNodeChild.setL1PlineLeft("100");
                    familyTreeNodeChild.setL2PlineLeft("50");
                } else {
                    familyTreeNodeChild.setL1PlineDisplay("none");
                    familyTreeNodeChild.setL2PlineWidth(format("%d",50 + (childCount-2)*100));
                    familyTreeNodeChild.setL2PlineLeft(format("%d",0 - (childCount-2)*100));
                }

                getJspContext().setAttribute("familyTreeNode", familyTreeNodeChild);
                getJspBody().invoke(null);


                childCount++;

            }




        } else {
            spouseFamilyFamilyTreeNode.setLeft(String.format("%d", (activePersonPosition + spouseNumber + afterActivePersonOffset) * FamilyTreeNode.FAMILY_NODE_WIDTH_EM));
            spouseFamilyFamilyTreeNode.setMlineLeft(String.format("-%d", ((activePersonPosition + spouseNumber + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM) - (((activePersonPosition + spouseNumber - 1) * FAMILY_NODE_WIDTH_EM) + WIDTH_LESS_ONE_PADDING)));
            spouseFamilyFamilyTreeNode.setMlineWidth(String.format("%d", ((activePersonPosition + spouseNumber + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM) - ((activePersonPosition + spouseNumber - 1) * FAMILY_NODE_WIDTH_EM) - NODE_WIDTH));

            getJspContext().setAttribute("familyTreeNode", spouseFamilyFamilyTreeNode);
            getJspBody().invoke(null);

            Iterator children = immediateFamily.getChildrenWithWife(spouse.getId()).iterator();


            int childCount = 1;

            while (children.hasNext()) {
                Person child = (Person) children.next();
                FamilyTreeNode familyTreeNodeChild = new FamilyTreeNode.Builder().build();
                
                familyTreeNodeChild.setPaddingTop(valueOf(NODE_PADDING_TOP));
                familyTreeNodeChild.setPaddingBottom(valueOf(NODE_PADDING_BOTTOM));
                familyTreeNodeChild.setPaddingLeft(valueOf(NODE_PADDING_LEFT));
                familyTreeNodeChild.setPaddingRight(valueOf(NODE_PADDING_RIGHT));                
                
                familyTreeNodeChild.setLeft(format("%d", (activePersonPosition + spouseNumber + afterActivePersonOffset + childCount-1) * FamilyTreeNode.FAMILY_NODE_WIDTH_EM));
                familyTreeNodeChild.setTop(String.valueOf(FamilyTreeNode.THIRD_GENERATION_TOP));
                familyTreeNodeChild.setId(format("%d", child.getId()));
                familyTreeNodeChild.setFullname(child.getFullname());
                familyTreeNodeChild.setMlineDisplay("none");

                familyTreeNodeChild.setBirthDate(birthDate(child));
                familyTreeNodeChild.setLocation(child.getAddress());
                familyTreeNodeChild.setL1PlineTop(valueOf(FamilyTreeNode.NODE_PADDING_TOP + (FamilyTreeNode.NODE_HEIGHT / 2)));                
                
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

    private static String birthDate(Person person) {
        return (person.getBirthDate() != null) ?  d.format(person.getBirthDate()) : "Unknown";
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
