package com.maurofokker.demo.converter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.maurofokker.demo.model.IndicatorHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Converter customizado que permite convertir el json de respuesta retornado desde
 * http://www.indecon.online/values/{key} a objeto de dominio IndicatorHistory
 */
@Component
@Slf4j
public class JsonStringToIndicatorHistoryConverter implements Converter<String, IndicatorHistory> {

    @Override
    public IndicatorHistory convert(String json) {
        log.info("Convirtiendo json en IndicatorHistory");
        Gson gson = new Gson();
        JsonObject convertedObject = gson.fromJson(json, JsonObject.class);

        JsonObject historicIndicatorValues = convertedObject.get("values").getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = historicIndicatorValues.entrySet();
        Map<Integer, Double> historicIndicatorValuesMap = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry: entries) {
            historicIndicatorValuesMap.put(Integer.parseInt(entry.getKey()), entry.getValue().getAsDouble());
        }

        IndicatorHistory indicatorHistory = IndicatorHistory.builder()
                .key(convertedObject.get("key").getAsString())
                .name(convertedObject.get("name").getAsString())
                .unit(convertedObject.get("unit").getAsString())
                .date(null)
                .value(null)
                .values(historicIndicatorValuesMap)
                .build();

        return indicatorHistory;
    }

}
