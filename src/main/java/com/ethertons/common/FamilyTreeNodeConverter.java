package com.ethertons.common;

import static java.lang.String.format;

import com.ethertons.domain.Person;

public class FamilyTreeNodeConverter {

    private static final int FAMILY_NODE_WIDTH_EM = 14;

    public static FamilyTreeNode convertParent(int parentCounter, Person person) {
        FamilyTreeNode familyTreeNode = new FamilyTreeNode.Spouse().build();
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

    public static FamilyTreeNode convertSibling(int siblingCounter, Person person, int activePersonPosition, int afterActivePersonOffset) {
        FamilyTreeNode familyTreeNode = new FamilyTreeNode.Spouse().build();
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
