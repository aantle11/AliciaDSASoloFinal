package com.alicia.bstapp;

import com.alicia.bstapp.model.TreeRecord;
import com.alicia.bstapp.repository.TreeRecordRepository;
import com.alicia.bstapp.service.BSTService;
import com.alicia.bstapp.util.BSTBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BSTServiceTest {

    @Test
    public void testBuildTreeAndSave() {
        TreeRecordRepository mockRepo = mock(TreeRecordRepository.class);
        BSTService service = new BSTService(mockRepo);

        BSTBuilder builder = service.buildTree("5,3,7");

        assertNotNull(builder);
        assertNotNull(builder.getRoot());
        assertEquals(5, builder.getRoot().value);

        ArgumentCaptor<TreeRecord> captor = ArgumentCaptor.forClass(TreeRecord.class);
        verify(mockRepo, times(1)).save(captor.capture());

        TreeRecord saved = captor.getValue();
        assertEquals("5,3,7", saved.getInputNumbers());
        assertNotNull(saved.getTreeJson());
    }
}