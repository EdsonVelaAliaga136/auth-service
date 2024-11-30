package com.evela.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@RequiredArgsConstructor
public class ExternalServiceClient {

    @Autowired
    @Qualifier("customRestTemplate")
    private RestTemplate restTemplate;

    public String callExternalService(String url){
        return restTemplate.getForObject(url, String.class);
    }

    public String authenticateUser(String authUrl, String requestPayload){
        return restTemplate.postForObject(authUrl, requestPayload, String.class);
    }

}
