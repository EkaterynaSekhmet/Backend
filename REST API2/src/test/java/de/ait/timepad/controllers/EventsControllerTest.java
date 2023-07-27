package de.ait.timepad.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addEvent() throws Exception{
        mockMvc.perform(post("/api/events")
                        .header("Content-Type","application/json")
                        .content("{\n" +
                                "\"date\": \"27.09.2023\",\n" +
                                "\"name\": \"Rammstein concert\"\n" +
                                "}"))
                .andExpect(status().isCreated()) // проверяет статус ответа
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.date", is("27.09.2023")))
                .andExpect(jsonPath("$.name", is("Rammstein concert")))
                .andExpect(jsonPath("$.state", is("PLANNED")));
    }
}