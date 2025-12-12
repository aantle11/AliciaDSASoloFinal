package com.alicia.bstapp;

import com.alicia.bstapp.controller.BSTController;
import com.alicia.bstapp.service.BSTService;
import com.alicia.bstapp.repository.TreeRecordRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BSTController.class)
public class BSTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BSTService bstService;

    @MockBean
    private TreeRecordRepository treeRecordRepository;

    @Test
    public void testProcessNumbersRoute() throws Exception {
        mockMvc.perform(post("/process-numbers")
                        .param("numbers", "5,2,8"))
                .andExpect(status().isOk())
                .andExpect(view().name("process-numbers"))
                .andExpect(model().attributeExists("numbers"))
                .andExpect(model().attributeExists("treeJson"));

        verify(bstService, atLeastOnce()).buildTree("5,2,8");
    }
}