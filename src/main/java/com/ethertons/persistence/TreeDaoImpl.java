package com.ethertons.persistence;

import java.util.List;
import javax.transaction.TransactionRolledbackException;

import com.ethertons.domain.Person;
import com.ethertons.domain.Surname;
import com.ethertons.domain.Tree;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TreeDaoImpl extends GenericDao  implements TreeDao {

    @Autowired
    public TreeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Tree findTreeWith(int treeId) {
        return (Tree)currentSession().get(Tree.class, treeId);
    }

    @Override
    public void storeTree(Tree tree) {
        currentSession().merge(tree);
    }

    @Override
    public List<Tree> findAllTrees() {
        return (List<Tree>)currentSession().createCriteria(Tree.class).list();
    }
}
