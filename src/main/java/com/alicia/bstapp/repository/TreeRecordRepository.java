package com.alicia.bstapp.repository;

import com.alicia.bstapp.model.TreeRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class TreeRecordRepository {

    private final List<TreeRecord> records = new ArrayList<>();

    public void save(TreeRecord record) {
        record.setId((long) (records.size() + 1));
        records.add(record);
    }

    public List<TreeRecord> findAll() {
        return records;
    }

    public Optional<TreeRecord> findById(Long id) {
        return records.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }
}