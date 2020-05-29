package com.maurofokker.demo.service;

import com.maurofokker.demo.fixture.IndicatorsFixture;
import com.maurofokker.demo.model.Indicator;
import com.maurofokker.demo.sal.IndeconAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IndicatorsServiceTest {

    @Mock
    private IndeconAPI indeconAPI;

    @InjectMocks
    private IndicatorsService indicatorsService;

    @Test
    void whenLastIndicatorsRequested_thenReturnMapWithIndicators() {

        Mockito.when(indeconAPI.getLastIndicators()).thenReturn(IndicatorsFixture.getLastIndicators());
        Map<String, Indicator> response = indicatorsService.getLastIndicators();
        assertThat(response).isNotEmpty();
        assertThat(response.size()).isEqualTo(10);

    }

}
