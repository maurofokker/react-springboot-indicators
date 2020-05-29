package com.maurofokker.demo.controller;

import com.maurofokker.demo.fixture.IndicatorsFixture;
import com.maurofokker.demo.service.IndicatorsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IndicatorsController.class)
public class IndicatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IndicatorsService service;

    @Test
    public void givenLastIndicators_whenGetLastIndicators_thenReturnJson() throws Exception {

        given(service.getLastIndicators()).willReturn(IndicatorsFixture.getLastIndicators());

        mockMvc.perform(MockMvcRequestBuilders.get("/indicators").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        .andExpect(jsonPath("$.cobre").exists());
    }
}
