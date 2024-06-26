package com.client.api.rasplus.integration.impl;

import com.client.api.rasplus.dto.client.CustomerDto;
import com.client.api.rasplus.dto.client.OrderDto;
import com.client.api.rasplus.dto.client.PaymentDto;
import com.client.api.rasplus.integration.RaspayIntegration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RaspayIntegrationImpl implements RaspayIntegration {

    @Value("${webservice.raspay.host}")
    private String raspayUrl;

    @Value("${webservice.raspay.customer}")
    private String customerUrl;

    @Value("${webservice.raspay.order}")
    private String orderUrl;

    @Value("${webservice.raspay.payment}")
    private String paymentUrl;

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
            var response = restTemplate.exchange(raspayUrl + customerUrl, HttpMethod.POST, request, CustomerDto.class);

            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        try {
            var request = new HttpEntity<>(dto, this.headers);
            var response = restTemplate.exchange(raspayUrl + orderUrl, HttpMethod.POST, request, OrderDto.class);

            return response.getBody();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        try {
            var request = new HttpEntity<>(dto, this.headers);
            var response = restTemplate.exchange(raspayUrl + paymentUrl, HttpMethod.POST, request, Boolean.class);

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
