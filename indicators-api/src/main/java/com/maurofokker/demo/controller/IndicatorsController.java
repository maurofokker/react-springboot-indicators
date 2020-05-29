package com.maurofokker.demo.controller;

import com.maurofokker.demo.model.Indicator;
import com.maurofokker.demo.model.IndicatorHistory;
import com.maurofokker.demo.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("indicators")
@CrossOrigin(origins = "*")
public class IndicatorsController {

    @Autowired
    private IndicatorsService service;

    @GetMapping("")
    public Map<String, Indicator> lastIndicators() {
        return service.getLastIndicators();
    }

    @GetMapping("/{key}")
    public IndicatorHistory valuesForIndicator(@PathVariable String key) {
        return service.getValuesForIndicator(key);
    }
}
