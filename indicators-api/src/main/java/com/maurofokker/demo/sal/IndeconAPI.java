package com.maurofokker.demo.sal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maurofokker.demo.converter.JsonStringToIndicatorHistoryConverter;
import com.maurofokker.demo.model.Indicator;
import com.maurofokker.demo.model.IndicatorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Map;

@Component
@Slf4j
public class IndeconAPI {

    public static final String URL_INDECON_LAST = "https://www.indecon.online/last";
    public static final String URL_INDECON_VALUES = "https://www.indecon.online/values/";

    @Autowired
    private JsonStringToIndicatorHistoryConverter jsonStringToIndicatorHistoryConverter;

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Indicator> getLastIndicators() {
        log.info("-> get last indicators");
        String jsonResponse = restTemplate.getForObject(URL_INDECON_LAST, String.class);
        Gson gson = new Gson();
        Type indicatorMapType = new TypeToken<Map<String, Indicator>>() {}.getType();
        Map<String, Indicator> nameIndicatorMap = gson.fromJson(jsonResponse, indicatorMapType);
        return nameIndicatorMap;
    }

    public IndicatorHistory getValuesForIndicator(String indicator) {
        log.info("--> get values for indicator {}", indicator);
        String jsonResponse = restTemplate.getForObject(URL_INDECON_VALUES + indicator, String.class);
        return jsonStringToIndicatorHistoryConverter.convert(jsonResponse);
    }
}
