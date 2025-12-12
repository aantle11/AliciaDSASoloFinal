package com.alicia.bstapp.controller;

import com.alicia.bstapp.model.TreeRecord;
import com.alicia.bstapp.repository.TreeRecordRepository;
import com.alicia.bstapp.util.BSTBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BSTController {

    private final TreeRecordRepository repository;

    public BSTController(TreeRecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/enter-numbers")
    public String enterNumbersPage() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {

        String[] parts = numbers.split(",");
        BSTBuilder bst = new BSTBuilder();

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part.trim());
                bst.insert(num);
            } catch (NumberFormatException e) {
                // ignore invalid entry
            }
        }

        bst.balance();

        String treeJson = bst.toJson();

        TreeRecord record = new TreeRecord(numbers, treeJson);
        repository.save(record);

        model.addAttribute("numbers", numbers);
        model.addAttribute("treeJson", treeJson);

        return "process-numbers";
    }

    @GetMapping("/previous-trees")
    public String getPreviousTrees(Model model) {
        List<TreeRecord> trees = repository.findAll();

        model.addAttribute("trees", trees);
        return "previous-trees";
    }
}