package com.microservice.config;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

    @Value("${my.greeting:defaultValue}")
    private String greeting;

    @Value("static data hai")
    private String staticData;

    @Value("${app.list.demo}")
    private List<String> listData;

    @Value("#{${dbValues}}")
    private Map<String, String> mapData;

    @Autowired
    private DBSettings databaseSettings;

    @Autowired
    private Environment env;

    @GetMapping("/greeting")
    String getGreeting(){
        return greeting + " " + staticData + " " + listData + " " + mapData + " " + databaseSettings.getConnection() + " " + env.toString();
    }
    
}
