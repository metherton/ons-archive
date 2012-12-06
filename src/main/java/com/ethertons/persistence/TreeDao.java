package com.ethertons.persistence;

import java.util.List;

import com.ethertons.domain.Tree;

public interface TreeDao {

    Tree findTreeWith(int treeId);

    void storeTree(Tree tree);

    List<Tree> findAllTrees();
}
