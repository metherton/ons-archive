package com.ethertons.common;

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

    static class ParentNodeConverter {
        public static FamilyTreeNode convert(int parentCounter, Person person) {
            FamilyTreeNode familyTreeNode = new FamilyTreeNode();
            familyTreeNode.setLeft(String.format("%d", (parentCounter)* FAMILY_NODE_WIDTH_EM));
            familyTreeNode.setTop("0");
            familyTreeNode.setId(format("%d", person.getId()));
            familyTreeNode.setFullname(person.getFullname());
            if (parentCounter==0) {
                familyTreeNode.setMlineDisplay("block");
                familyTreeNode.setMlineLeft("12");
                familyTreeNode.setMlineTop("3.8");
                familyTreeNode.setMlineWidth("4");
            }
            familyTreeNode.setL1PlineDisplay("none");
            familyTreeNode.setL2PlineDisplay("none");
            familyTreeNode.setL3PlineDisplay("none");
            return familyTreeNode;
        }
    }

    static class SiblingNodeConverter {
        public static FamilyTreeNode convert(int siblingCounter, Person person, int activePersonPosition, int afterActivePersonOffset) {
            FamilyTreeNode familyTreeNode = new FamilyTreeNode();
            if (siblingCounter <= activePersonPosition) {
                familyTreeNode.setLeft(String.format("%d", (siblingCounter) * FAMILY_NODE_WIDTH_EM));
                familyTreeNode.setTop("8");
                familyTreeNode.setId(format("%d", person.getId()));
                familyTreeNode.setFullname(person.getFullname());
            } else {
                familyTreeNode.setLeft(String.format("%d", (siblingCounter+afterActivePersonOffset)*FAMILY_NODE_WIDTH_EM));
                familyTreeNode.setTop("8");
                familyTreeNode.setId(format("%d", person.getId()));
                familyTreeNode.setFullname(person.getFullname());
            }

            if (siblingCounter == 0) {
                familyTreeNode.setL1PlineLeft("100");
                familyTreeNode.setL2PlineWidth("50");
                familyTreeNode.setL1PlineLeft("100");
                familyTreeNode.setL2PlineLeft("50");
            } else {
                if (siblingCounter <= activePersonPosition) {
                    familyTreeNode.setL1PlineDisplay("none");
                    familyTreeNode.setL2PlineWidth(String.format("%d",50 + (siblingCounter-1)*100));
                    familyTreeNode.setL2PlineLeft(String.format("%d",0 - (siblingCounter-1)*100));
                }  else {
                    familyTreeNode.setL1PlineDisplay("none");
                    familyTreeNode.setL2PlineWidth(String.format("%d",50 + (siblingCounter+afterActivePersonOffset-1)*100));
                    familyTreeNode.setL2PlineLeft(String.format("%d",0 - (siblingCounter+afterActivePersonOffset-1)*100));
                }
            }

            familyTreeNode.setMlineDisplay("none");

            return familyTreeNode;
        }
    }



    public void doTag() throws IOException, JspException {
        renderParentNodes();
        renderSiblings();
        renderWivesAndChildren();
    }

    private void renderWivesAndChildren() throws JspException, IOException {
        Iterator spouses = immediateFamily.getSpouses().iterator();
        int wifeNo = 1;

        while (spouses.hasNext()) {
            Person wife = (Person) spouses.next();

            int afterActivePersonOffset = AfterActivePersonWifeOffset.calculate(immediateFamily, wifeNo);

            int activePersonPosition = immediateFamily.findSiblingPosition(immediateFamily.getActivePersonId());

            FamilyTreeNode wifeFamilyTreeNode = new FamilyTreeNode();
            if (wifeNo == 1) {
                wifeFamilyTreeNode.setLeft(String.format("%d", (activePersonPosition + wifeNo)*FAMILY_NODE_WIDTH_EM));
                wifeFamilyTreeNode.setTop("8");
                wifeFamilyTreeNode.setId(format("%d", wife.getId()));
                wifeFamilyTreeNode.setFullname(wife.getFullname());
                wifeFamilyTreeNode.setMlineDisplay("block");
                wifeFamilyTreeNode.setMlineLeft("-2");
                wifeFamilyTreeNode.setMlineWidth("4");
                wifeFamilyTreeNode.setMlineTop("3.8");
                wifeFamilyTreeNode.setL1PlineDisplay("none");
                wifeFamilyTreeNode.setL3PlineDisplay("none");

                getJspContext().setAttribute("familyTreeNode", wifeFamilyTreeNode);
                getJspBody().invoke(null);

                Iterator children = immediateFamily.getChildrenWithWife(wife.getId()).iterator();


                int childCount = 1;

                while (children.hasNext()) {
                    Person child = (Person) children.next();
                    FamilyTreeNode familyTreeNodeChild = new FamilyTreeNode();
                    familyTreeNodeChild.setLeft(String.format("%d", (activePersonPosition + (childCount-1)) * FAMILY_NODE_WIDTH_EM));
                    familyTreeNodeChild.setTop("16");
                    familyTreeNodeChild.setId(format("%d", child.getId()));
                    familyTreeNodeChild.setFullname(child.getFullname());
                    familyTreeNodeChild.setMlineDisplay("none");


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

                wifeFamilyTreeNode.setLeft(String.format("%d",
                                                    (activePersonPosition + wifeNo + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM ) );
                wifeFamilyTreeNode.setTop("8");
                wifeFamilyTreeNode.setId(format("%d", wife.getId()));
                wifeFamilyTreeNode.setFullname(wife.getFullname());

                wifeFamilyTreeNode.setMlineDisplay("block");
                wifeFamilyTreeNode.setMlineLeft(String.format("-%d",( (activePersonPosition + wifeNo + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM ) - (((activePersonPosition + wifeNo - 1)*14) + 12 ) ));
                wifeFamilyTreeNode.setMlineWidth(String.format("%d",((activePersonPosition + wifeNo + afterActivePersonOffset) * FAMILY_NODE_WIDTH_EM ) - ((activePersonPosition + wifeNo - 1)*14) - 10 ));
                wifeFamilyTreeNode.setMlineTop("3.8");
                wifeFamilyTreeNode.setL1PlineDisplay("none");
                wifeFamilyTreeNode.setL3PlineDisplay("none");

                getJspContext().setAttribute("familyTreeNode", wifeFamilyTreeNode);
                getJspBody().invoke(null);

                Iterator children = immediateFamily.getChildrenWithWife(wife.getId()).iterator();


                int childCount = 1;

                while (children.hasNext()) {
                    Person child = (Person) children.next();
                    FamilyTreeNode familyTreeNodeChild = new FamilyTreeNode();
                    familyTreeNodeChild.setLeft(String.format("%d", (activePersonPosition + wifeNo + afterActivePersonOffset + childCount-1) * FAMILY_NODE_WIDTH_EM));
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


            wifeNo++;
        }
    }

    private void renderSiblings() throws JspException, IOException {
        Iterator siblings = immediateFamily.getSiblings().iterator();
        int siblingCount = 0;
        int activePersonPosition = immediateFamily.findSiblingPosition(immediateFamily.getActivePersonId());
        int afterActivePersonOffset = AfterActivePersonOffset.calculate(immediateFamily);
        while (siblings.hasNext()) {
            Person person = (Person) siblings.next();
            getJspContext().setAttribute("familyTreeNode", SiblingNodeConverter.convert(siblingCount, person, activePersonPosition, afterActivePersonOffset));
            getJspBody().invoke(null);
            siblingCount++;
        }
    }

    private void renderParentNodes() throws JspException, IOException {
        Iterator parents = immediateFamily.getParents().iterator();
        int parentCount = 0;
        while (parents.hasNext()) {
            Person person = (Person) parents.next();
            getJspContext().setAttribute("familyTreeNode", ParentNodeConverter.convert(parentCount, person));
            getJspBody().invoke(null);
            parentCount++;
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
                System.out.println("wife position is " + wifePosition + " and spouse cont is " + spouseCount);
                if (spouseCount == wifePosition) {
                    return offset;
                }
                
                Person wife = (Person) spouses.next();
                int numberOfChildren = immediateFamily.getChildrenWithWife(wife.getId()).size();
                System.out.println("number of childer for " + wife.getFullname() + " is " + numberOfChildren);
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
