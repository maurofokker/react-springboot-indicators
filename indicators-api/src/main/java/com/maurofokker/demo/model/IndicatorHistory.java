package com.maurofokker.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class IndicatorHistory extends Indicator {
    private Map<Integer, Double> values;
}
