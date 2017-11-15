package com.example.elklog.control;


import com.example.elklog.model.Weather;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static net.logstash.logback.argument.StructuredArguments.entries;


/**
 * Created by yookeun on 2017. 11. 9..
 */
@Controller
public class LogController {

    Logger logger = LoggerFactory.getLogger("ykkim");
    Logger loggerStash = LoggerFactory.getLogger("ykkim_logstash");

    @RequestMapping(value = "/")
    @ResponseBody
    public String index() {
        Weather weather = new Weather();
        weather.setCity("seoul");
        weather.setSeason("winter");
        weather.setTemperature(12.3);
        weather.setPopulation(12000000);
        logger.info("{}",weather);
        /*
        Map<String, Object> map = new HashMap<>();
        map.put("city", weather.getCity());
        map.put("temperature", weather.getTemperature());
        map.put("population", weather.getPopulation());
        loggerStash.info("{}", entries(map));
        */
        Gson gson = new Gson();
        loggerStash.info("{}", gson.toJson(weather));


        return "Hello, world";
    }
}
