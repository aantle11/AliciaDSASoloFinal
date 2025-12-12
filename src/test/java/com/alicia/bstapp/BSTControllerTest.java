package com.alicia.bstapp;

import com.alicia.bstapp.controller.BSTController;
import com.alicia.bstapp.model.TreeRecord;
import com.alicia.bstapp.repository.TreeRecordRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BSTControllerTest {

    @Mock
    private TreeRecordRepository repository;

    @Mock
    private Model model;

    @InjectMocks
    private BSTController controller;

    public BSTControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessNumbersRoute() {

        String input = "5,2,8";

        String result = controller.processNumbers(input, model);

        verify(repository).save(any(TreeRecord.class));

        verify(model).addAttribute("numbers", input);
        verify(model).addAttribute(eq("treeJson"), any(String.class));

        assertEquals("process-numbers", result);
    }
}