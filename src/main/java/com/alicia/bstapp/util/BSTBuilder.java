package com.alicia.bstapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BSTBuilder {
    private TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.value) {
            current.left = insertRec(current.left, value);
        } else if (value > current.value) {
            current.right = insertRec(current.right, value);
        }

        return current;
    }

    public TreeNode getRoot() {
        return root;
    }

    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting tree to JSON", e);
        }
    }
}
