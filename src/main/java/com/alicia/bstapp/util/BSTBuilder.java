package com.alicia.bstapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

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

    // Bonus - Return balanced binary search tree to user
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);
    }

    private TreeNode buildBalanced(List<Integer> values, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(values.get(mid));

        node.left = buildBalanced(values, start, mid - 1);
        node.right = buildBalanced(values, mid + 1, end);

        return node;
    }

    public void balance() {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        root = buildBalanced(values, 0, values.size() - 1);
    }
}
