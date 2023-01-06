package com.example.beatsbyusbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
  {
                 "name": "Beat 1",
                 "tempo": 128
            }
  */
@SpringBootTest
@AutoConfigureMockMvc
class BeatControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    void getBeat_shouldReturnEmptyList() throws Exception {
        //GIVEN
        String expectedJSON = """
            [
            
            ]
            """;
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("/api/beats"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }
}