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
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addUser() throws Exception{
        mockMvc.perform(post("/api/users")
                .header("Content-Type","application/json")
                .content("{" +
                        "\"email\": \"ekateryna@gmail.com\"," +
                        "\"password\": \"fdifii66\"" +
                        "}"))
                .andExpect(status().isCreated()) // проверяет статус ответа
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.email", is("ekateryna@gmail.com")))
                .andExpect(jsonPath("$.role", is("USER")))
                .andExpect(jsonPath("$.state", is("NOT_CONFIRMED")));
    }
}
