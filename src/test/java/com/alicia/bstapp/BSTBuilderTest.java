package com.alicia.bstapp;

import com.alicia.bstapp.util.BSTBuilder;
import com.alicia.bstapp.util.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BSTBuilderTest {

    @Test
    public void testInsertCreatesRoot() {
        BSTBuilder bst = new BSTBuilder();
        bst.insert(5);

        TreeNode root = bst.getRoot();
        assertNotNull(root);
        assertEquals(5, root.value);
    }

    @Test
    public void testInsertMultipleValues() {
        BSTBuilder bst = new BSTBuilder();
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);

        TreeNode root = bst.getRoot();

        assertEquals(5, root.value);
        assertEquals(2, root.left.value);
        assertEquals(8, root.right.value);
    }

    @Test
    public void testJsonOutputNotNull() {
        BSTBuilder bst = new BSTBuilder();
        bst.insert(5);
        bst.insert(3);

        String json = bst.toJson();
        assertNotNull(json);
        assertTrue(json.contains("5"));
        assertTrue(json.contains("3"));
    }
}