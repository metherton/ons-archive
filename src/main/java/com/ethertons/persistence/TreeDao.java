package com.ethertons.persistence;

import com.ethertons.domain.Person;
import com.ethertons.domain.Tree;

public interface TreeDao {

    Tree findTreeWith(int treeId);

    void storeTree(Tree tree);
}
