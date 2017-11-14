package com.example.elklog.model;

import lombok.Data;

/**
 * Created by yookeun on 2017. 11. 9..
 */
@Data
public class Weather {
    private String city;
    private String season;
    private double temperature;
    private long population;
}
