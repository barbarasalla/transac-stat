package com.practice.transacstat.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.OffsetDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createTransacaoWithSucess() throws Exception {
        mockMvc.perform(post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"valor\": 100.0, \"dataHora\": \"2024-04-04T10:00:00-03:00\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void createTransacaoWithErrorInvalidDate() throws Exception {
        String dateFuture = String.valueOf(OffsetDateTime.now().plusMonths(1L));
        String json = String.format("""
                                        {
                                            "valor": 100.00,
                                            "dataHora": "%s"
                                        }
                                    """, dateFuture);

        mockMvc.perform(post("/transacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().is(422));
    }

    @Test
    void createTransacaoWithErrorInvalidArgument() throws Exception {
        mockMvc.perform(post("/transacao")
                .contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().is(400));
    }

    @Test
    void deleteTransacaoListWithSucess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/transacao/all")).andExpect(status().isOk());
    }
}
