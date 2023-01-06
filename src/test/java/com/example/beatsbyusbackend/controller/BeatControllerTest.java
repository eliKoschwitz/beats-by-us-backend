package com.example.beatsbyusbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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

    @Test
    void addBeat_shouldReturnsAddedBeat() throws Exception {
        //GIVEN
        String requestBody = """
                    {
                        "name": "Beat 2",
                        "tempo": 128,
                        "beatList": [
                                        {
                                            "name":"beatChain1",\s
                                            "beats":[true, false, true, false, true, false, true, false]
                                         }
                                
                                    ]
                    }
                """;

        String expectedJSON = """
                  {
                      "name": "Beat 2",
                      "tempo": 128,
                      "beatList": [
                                      {
                                          "name":"beatChain1",\s
                                          "beats":[true, false, true, false, true, false, true, false]
                                       }
                  
                                  ]
                  }
                """;

        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.post("/api/beats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void deleteBeat_whenIDValid_thenDeleteBeat() throws Exception {
        //GIVEN
        String requestBody = """
                    {
                        "id": "123",
                        "name": "Beat 2",
                        "tempo": 128,
                        "beatList": [
                                        {
                                            "name":"beatChain1",
                                            "beats":[true, false, true, false, true, false, true, false]
                                         }
                                
                                    ]
                    }
                """;

        String emptyJSON = """
                [
                ]
                """;

        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.post("/api/beats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(requestBody));

        mvc.perform(MockMvcRequestBuilders.delete("/api/beats/123"))
                .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/api/beats"))
                .andExpect(status().isOk())
                .andExpect(content().json(emptyJSON));
    }
}