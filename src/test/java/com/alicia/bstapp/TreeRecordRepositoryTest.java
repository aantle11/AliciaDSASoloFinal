package com.alicia.bstapp;

import com.alicia.bstapp.model.TreeRecord;
import com.alicia.bstapp.repository.TreeRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TreeRecordRepositoryTest {

    @Autowired
    private TreeRecordRepository repository;

    @Test
    public void testSaveAndRetrieveRecord() {
        TreeRecord record = new TreeRecord("5,2,8", "{json}");
        repository.save(record);

        TreeRecord found = repository.findById(record.getId()).orElse(null);

        assertNotNull(found);
        assertEquals("5,2,8", found.getInputNumbers());
        assertEquals("{json}", found.getTreeJson());
    }
}