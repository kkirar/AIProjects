package com.ai.service;

import com.ai.model.Request;
import com.ai.model.WeatherResponse;

public class WeatherClient extends WebServiceGatewaySupport {

    public WeatherResponse getWeatherReport() {
        Request request = new Request();
        return (WeatherResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}