package com.lottery.lotteryservice.pl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ticketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addTicket() throws Exception {
        mockMvc.perform(post("/ticket?lines=5")
                .contentType("application/json"))
                .andExpect(status().isCreated());
    }

    @Test
    void amendTicket() throws Exception {
        mockMvc.perform(put("/ticket/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}