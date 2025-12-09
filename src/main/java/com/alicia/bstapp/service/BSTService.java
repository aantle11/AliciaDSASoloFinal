package com.alicia.bstapp.service;

import com.alicia.bstapp.model.TreeRecord;
import com.alicia.bstapp.repository.TreeRecordRepository;
import com.alicia.bstapp.util.BSTBuilder;
import com.alicia.bstapp.util.TreeNode;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BSTService {
    private final TreeRecordRepository repository;

    public BSTService(TreeRecordRepository repository) {
        this.repository = repository;
    }

    public BSTBuilder buildTree(String numberInput) {

        BSTBuilder builder = new BSTBuilder();

        String[] parts = numberInput.split(",");
        for (String p : parts) {
            int num = Integer.parseInt(p.trim());
            builder.insert(num);
        }

        TreeRecord record = new TreeRecord(numberInput);
        repository.save(record);

        return builder;
    }
}
