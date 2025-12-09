package com.alicia.bstapp.repository;

import com.alicia.bstapp.model.TreeRecord;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class TreeRecordRepository {
    private final List<TreeRecord> records = new ArrayList<>();

    public void save (TreeRecord record) {
        records.add(record);
    }

    public List<TreeRecord> findAll() {
        return records;
    }
}
