package com.alicia.bstapp;

import com.alicia.bstapp.model.TreeRecord;
import com.alicia.bstapp.repository.TreeRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TreeRecordRepositoryTest {
    @Autowired
    private TreeRecordRepository repository;

    @Test
    void testSaveAndRetrieveRecord() {
        TreeRecord record = new TreeRecord("5,2,8", "{json}");
        repository.saveAndFlush(record);

        TreeRecord found = repository.findById(record.getId()).orElse(null);

        assertNotNull(found);
        assertEquals("5,2,8", found.getInputNumbers());
        assertEquals("{json}", found.getTreeJson());
    }
}