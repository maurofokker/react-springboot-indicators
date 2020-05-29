package com.maurofokker.demo.service;

import com.maurofokker.demo.model.Indicator;
import com.maurofokker.demo.model.IndicatorHistory;
import com.maurofokker.demo.sal.IndeconAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class IndicatorsService {

    @Autowired
    private IndeconAPI indeconAPI;

    @Cacheable(cacheNames = "indicators")
    public Map<String, Indicator> getLastIndicators() {

        // slowResponseSimulation();

        return indeconAPI.getLastIndicators();

    }

    @Cacheable(cacheNames = "historic")
    public IndicatorHistory getValuesForIndicator(String key) {

        return indeconAPI.getValuesForIndicator(key);

    }

    /**
     * Para probar el cache simula una respuesta lenta del service
     */
    private void slowResponseSimulation() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
