package com.maurofokker.demo.fixture;

import com.maurofokker.demo.model.Indicator;

import java.util.HashMap;
import java.util.Map;

public class IndicatorsFixture {

    public static Map<String, Indicator> getLastIndicators() {
        Map<String, Indicator> lastIndicators = new HashMap<>();
        lastIndicators.put("cobre",
                Indicator.builder().key("cobre").name("Precio del Cobre, dólares por libra")
                        .unit("dolar").date(1584489600).value(2.39).build());
        lastIndicators.put("dolar",
                Indicator.builder().key("dolar").name("Dolar observado")
                        .unit("pesos").date(1584489600).value(855.09).build());
        lastIndicators.put("euro",
                Indicator.builder().key("euro").name("Euro")
                        .unit("pesos").date(1584489600).value(938.42).build());
        lastIndicators.put("ipc",
                Indicator.builder().key("ipc").name("Indice de Precios al Consumidor (Var. c/r al período anterior)")
                        .unit("porcentual").date(1577836800).value(1.1).build());
        lastIndicators.put("ivp",
                Indicator.builder().key("ivp").name("Indice de valor promedio")
                        .unit("pesos").date(1586390400).value(29706.22).build());
        lastIndicators.put("oro",
                Indicator.builder().key("oro").name("Precio del Oro, dólares por onza")
                        .unit("dolar").date(1584576000).value(1473.2).build());
        lastIndicators.put("plata",
                Indicator.builder().key("plata").name("Precio de la Plata, dólares por onza")
                        .unit("dolar").date(1584576000).value(11.69).build());
        lastIndicators.put("uf",
                Indicator.builder().key("uf").name("Unidad de fomento")
                        .unit("pesos").date(1586390400).value(28630.63).build());
        lastIndicators.put("utm",
                Indicator.builder().key("utm").name("Unidad tributaria mensual")
                        .unit("pesos").date(1583020800).value(50021.0).build());
        lastIndicators.put("yen",
                Indicator.builder().key("yen").name("yen")
                        .unit("dolar").date(1584489600).value(107.33).build());
        return lastIndicators;
    }
}
