package com.ethertons.web;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

import com.ethertons.domain.OnsService;
import com.ethertons.domain.Tree;

public class TreeEditor  extends PropertyEditorSupport {

    private final OnsService onsService;

    public TreeEditor(OnsService onsService) {
        this.onsService = onsService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isBlank(text)) {
            return;
        } else {
            Tree tree = onsService.findTreeWith((int) Integer.parseInt(text));
            setValue(tree);
        }
    }

    @Override
    public String getAsText() {
        Tree tree = (Tree) getValue();
        if (tree == null) {
            return null;
        } else {
            return Integer.toString(tree.getId());
        }
    }

}
