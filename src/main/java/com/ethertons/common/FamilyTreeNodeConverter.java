package com.ethertons.common;

import static java.lang.String.format;

import com.ethertons.domain.Person;

public class FamilyTreeNodeConverter {

//    public static final String NODE_WIDTH = "10";
//    public static final String NODE_HEIGHT = "4";
//    public static final String NODE_PADDING_TOP = "2";
//    public static final String NODE_PADDING_BOTTOM = "2";
//    public static final String NODE_PADDING_LEFT = "2";
//    public static final String NODE_PADDING_RIGHT = "2";    
    
    private static final int FAMILY_NODE_HORIZONTAL_SPACE_EM = Integer.parseInt(FamilyTreeNode.Builder.NODE_PADDING_LEFT) + Integer.parseInt(FamilyTreeNode.Builder.NODE_PADDING_RIGHT);
    private static final int FAMILY_NODE_VERTICAL_SPACE_EM = Integer.parseInt(FamilyTreeNode.Builder.NODE_PADDING_TOP) + Integer.parseInt(FamilyTreeNode.Builder.NODE_PADDING_BOTTOM);;
    private static final int FAMILY_NODE_WIDTH_EM = FAMILY_NODE_HORIZONTAL_SPACE_EM + Integer.parseInt(FamilyTreeNode.Builder.NODE_WIDTH);

    public static FamilyTreeNode convertParent(int parentCounter, Person person) {
        FamilyTreeNode familyTreeNode = new FamilyTreeNode.Builder().build();
        familyTreeNode.setLeft(String.format("%d", (parentCounter)* FAMILY_NODE_WIDTH_EM));
        familyTreeNode.setTop("0");
        familyTreeNode.setId(format("%d", person.getId()));
        familyTreeNode.setFullname(person.getFullname());
        familyTreeNode.setPaddingTop(String.valueOf(FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingBottom(String.valueOf(FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingLeft(String.valueOf(FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));
        familyTreeNode.setPaddingRight(String.valueOf(FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));
        
        if (parentCounter==0) {
            familyTreeNode.setMlineDisplay("block");
            familyTreeNode.setMlineLeft(String.valueOf((2 + Integer.parseInt(FamilyTreeNode.Builder.NODE_WIDTH))));
            familyTreeNode.setMlineTop(String.valueOf(2 + Integer.parseInt(FamilyTreeNode.Builder.NODE_HEIGHT)/2 - 0.2));
            familyTreeNode.setMlineWidth(String.valueOf(FAMILY_NODE_HORIZONTAL_SPACE_EM));
        }
        familyTreeNode.setL1PlineDisplay("none");
        familyTreeNode.setL2PlineDisplay("none");
        familyTreeNode.setL3PlineDisplay("none");

        return familyTreeNode;
    }

    public static FamilyTreeNode convertSibling(int siblingCounter, Person person, int activePersonPosition, int afterActivePersonOffset) {
        FamilyTreeNode familyTreeNode = new FamilyTreeNode.Builder().build();
        familyTreeNode.setTop(String.valueOf(FAMILY_NODE_VERTICAL_SPACE_EM + Integer.parseInt(FamilyTreeNode.Builder.NODE_HEIGHT)));
        familyTreeNode.setPaddingTop(String.valueOf(FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingBottom(String.valueOf(FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingLeft(String.valueOf(FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));
        familyTreeNode.setPaddingRight(String.valueOf(FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));        
        if (siblingCounter <= activePersonPosition) {
            familyTreeNode.setLeft(String.format("%d", (siblingCounter) * FAMILY_NODE_WIDTH_EM));
            familyTreeNode.setId(format("%d", person.getId()));
            familyTreeNode.setFullname(person.getFullname());
        } else {
            familyTreeNode.setLeft(String.format("%d", (siblingCounter+afterActivePersonOffset)*FAMILY_NODE_WIDTH_EM));
            familyTreeNode.setId(format("%d", person.getId()));
            familyTreeNode.setFullname(person.getFullname());
        }

        familyTreeNode.setL1PlineTop(String.valueOf(FAMILY_NODE_VERTICAL_SPACE_EM / 2 + (Integer.parseInt(FamilyTreeNode.Builder.NODE_HEIGHT) / 2)));
        if (siblingCounter == 0) {
            familyTreeNode.setL1PlineLeft("100");
            familyTreeNode.setL2PlineWidth("50");
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
