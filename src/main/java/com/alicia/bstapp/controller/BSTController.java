package com.alicia.bstapp.controller;

import com.alicia.bstapp.util.BSTBuilder;
import com.alicia.bstapp.util.TreeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class BSTController {

    private List<String> previousTrees = new ArrayList<>();

    @GetMapping("/enter-numbers")
    public String enterNumbersPage() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public Map<String, Object> processNumbers(@RequestParam String numbers) {
        String[] parts = numbers.split(",");
        BSTBuilder bst = new BSTBuilder();
        for (String part : parts) {
            try {
                int num = Integer.parseInt(part.trim());
                bst.insert(num);
            } catch (NumberFormatException e) {
                // ignore invalid numbers
            }
        }

        String treeJson = bst.toJson();

        previousTrees.add(treeJson);

        Map<String, Object> response = new HashMap<>();
        response.put("tree", treeJson);
        return response;
    }

    @GetMapping("/previous-trees")
    @ResponseBody
    public List<String> getPreviousTrees() {
        return previousTrees;
    }
}
