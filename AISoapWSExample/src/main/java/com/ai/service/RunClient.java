package com.ai.service;

import com.ai.model.WeatherResponse;

public class RunClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        WeatherClient client = context.getBean(WeatherClient.class);
        WeatherResponse response = client.getWeatherReport();
        System.out.println("Beer response: " + response.getGetWeatherResult());
    }

}
