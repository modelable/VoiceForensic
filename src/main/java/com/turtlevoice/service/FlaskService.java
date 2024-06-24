package com.turtlevoice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlaskService {

    @Value("${flask.url}")
    private final String flaskUrl = "https://2903-223-194-159-214.ngrok-free.app/";
    private final RestTemplate restTemplate = new RestTemplate();

    public String get(String endpoint){
        String response = restTemplate.getForObject(flaskUrl + endpoint, String.class);
        System.out.println("Response from '/" + endpoint + "': " + response);
        return response;
    }




}
