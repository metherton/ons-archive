package com.ethertons.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.ethertons.domain.Tree;


public class GedcomTreeTag extends SimpleTagSupport {

    private List<Tree> trees;
    private int selectedTree;

    public void doTag() throws IOException, JspException {
        for(Tree tree : trees)  {
            getJspContext().setAttribute("tree", tree);
            getJspBody().invoke(null);
        }
    }

    public void setTrees(List<Tree> trees) {
        this.trees = trees;
    }

    public void setSelectedTree(int selectedTree) {
        this.selectedTree = selectedTree;
    }
}
