package com.maurofokker.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Indicator {

    private String key;
    private String name;
    private String unit;
    private Integer date;
    private Double value;
}
