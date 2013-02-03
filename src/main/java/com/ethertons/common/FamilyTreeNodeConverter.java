package com.ethertons.common;

import static com.ethertons.common.FamilyTreeNode.FAMILY_NODE_HORIZONTAL_SPACE_EM;
import static com.ethertons.common.FamilyTreeNode.NODE_HEIGHT;
import static com.ethertons.common.FamilyTreeNode.NODE_WIDTH;
import static java.lang.String.format;

import java.text.DateFormat;
import com.ethertons.domain.Person;

public class FamilyTreeNodeConverter {
 
    private static DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM);
    
    public static FamilyTreeNode convertParent(int parentCounter, Person person) {
        FamilyTreeNode familyTreeNode = new FamilyTreeNode.Builder().build();
        familyTreeNode.setLeft(String.format("%d", (parentCounter) * FamilyTreeNode.FAMILY_NODE_WIDTH_EM));
        familyTreeNode.setTop("0");
        familyTreeNode.setId(format("%d", person.getId()));
        familyTreeNode.setFullname(person.getFullname());
        familyTreeNode.setBirthDate(birthDate(person));
        familyTreeNode.setLocation(person.getAddress());
        familyTreeNode.setPaddingTop(String.valueOf(FamilyTreeNode.FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingBottom(String.valueOf(FamilyTreeNode.FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingLeft(String.valueOf(FamilyTreeNode.FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));
        familyTreeNode.setPaddingRight(String.valueOf(FamilyTreeNode.FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));
        
        if (parentCounter==0) {
            familyTreeNode.setMlineDisplay("block");
            familyTreeNode.setMlineLeft(String.valueOf((2 + NODE_WIDTH)));
            familyTreeNode.setMlineTop(String.valueOf(2 + NODE_HEIGHT / 2 - 0.2));
            familyTreeNode.setMlineWidth(String.valueOf(FAMILY_NODE_HORIZONTAL_SPACE_EM));
        }
        familyTreeNode.setL1PlineDisplay("none");
        familyTreeNode.setL2PlineDisplay("none");
        familyTreeNode.setL3PlineDisplay("none");

        return familyTreeNode;
    }



    private static String birthDate(Person person) {
        return (person.getBirthDate() != null) ?  d.format(person.getBirthDate()) : "Unknown";
    }


    
    public static FamilyTreeNode convertSibling(int siblingCounter, Person person, int activePersonPosition, int afterActivePersonOffset) {
        FamilyTreeNode familyTreeNode = new FamilyTreeNode.Builder().build();
        familyTreeNode.setTop(String.valueOf(FamilyTreeNode.FAMILY_NODE_VERTICAL_SPACE_EM + NODE_HEIGHT));
        familyTreeNode.setPaddingTop(String.valueOf(FamilyTreeNode.FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingBottom(String.valueOf(FamilyTreeNode.FAMILY_NODE_VERTICAL_SPACE_EM / 2));
        familyTreeNode.setPaddingLeft(String.valueOf(FamilyTreeNode.FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));
        familyTreeNode.setPaddingRight(String.valueOf(FamilyTreeNode.FAMILY_NODE_HORIZONTAL_SPACE_EM / 2));    
        familyTreeNode.setBirthDate(birthDate(person));
        familyTreeNode.setLocation(person.getAddress());        
        if (siblingCounter <= activePersonPosition) {
            familyTreeNode.setLeft(String.format("%d", (siblingCounter) * FamilyTreeNode.FAMILY_NODE_WIDTH_EM));
            familyTreeNode.setId(format("%d", person.getId()));
            familyTreeNode.setFullname(person.getFullname());
        } else {
            familyTreeNode.setLeft(String.format("%d", (siblingCounter+afterActivePersonOffset) * FamilyTreeNode.FAMILY_NODE_WIDTH_EM));
            familyTreeNode.setId(format("%d", person.getId()));
            familyTreeNode.setFullname(person.getFullname());
        }

        familyTreeNode.setL1PlineTop(String.valueOf(FamilyTreeNode.FAMILY_NODE_VERTICAL_SPACE_EM / 2 + (NODE_HEIGHT / 2)));
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
