package com.alicia.bstapp;

import com.alicia.bstapp.util.BSTBuilder;
import com.alicia.bstapp.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedTest {

    @Test
    public void testBalancedTreeRoot() {

        BSTBuilder bst = new BSTBuilder();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.balance();

        TreeNode root = bst.getRoot();

        assertEquals(3, root.value);
    }
}