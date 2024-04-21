package com.client.api.rasplus.integration.impl;

import com.client.api.rasplus.dto.client.CustomerDto;
import com.client.api.rasplus.dto.client.OrderDto;
import com.client.api.rasplus.dto.client.PaymentDto;
import com.client.api.rasplus.integration.RaspayIntegration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RaspayIntegrationImpl implements RaspayIntegration {

    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public RaspayIntegrationImpl() {
        this.restTemplate = new RestTemplate();
        this.headers = getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            var request = new HttpEntity<>(dto, this.headers);
            var response = restTemplate.exchange("http://localhost:8081/ws-raspay/v1/customer", HttpMethod.POST, request, CustomerDto.class);

            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        try {
            var request = new HttpEntity<>(dto, this.headers);
            var response = restTemplate.exchange("http://localhost:8081/ws-raspay/v1/order", HttpMethod.POST, request, OrderDto.class);

            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        try {
            var request = new HttpEntity<>(dto, this.headers);
            var response = restTemplate.exchange("http://localhost:8081/ws-raspay/v1/payment/credit-card/", HttpMethod.POST, request, Boolean.class);

            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();

        String credentials = "rasmooplus:r@sm00";
        String base64 = Base64.encodeBase64String(credentials.getBytes());

        headers.add("Authorization", "Basic " + base64);
        return headers;
    }
}
