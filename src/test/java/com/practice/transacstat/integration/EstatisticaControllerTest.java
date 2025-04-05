package com.practice.transacstat.integration;

import com.practice.transacstat.estatistica.Estatistica;
import com.practice.transacstat.estatistica.EstatisticaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.DoubleSummaryStatistics;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EstatisticaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EstatisticaService service;

    @Test
    void getEstatisticaWithSucess() throws Exception {
        String expectedJson = """
        {
          "count": 2,
          "sum": 100.0,
          "avg": 50.0,
          "min": 30.0,
          "max": 70.0
        }
        """;

        when(service.calculeStatic()).thenReturn(new Estatistica(new DoubleSummaryStatistics(2, 30.0, 70.0, 100.00)));
        mockMvc.perform(get("/estatistica")).andExpect(status().isOk()).andExpect(content().json(expectedJson));
    }
}
