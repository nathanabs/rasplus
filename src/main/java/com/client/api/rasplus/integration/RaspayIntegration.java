package com.client.api.rasplus.integration;

import com.client.api.rasplus.dto.client.CustomerDto;
import com.client.api.rasplus.dto.client.OrderDto;
import com.client.api.rasplus.dto.client.PaymentDto;

public interface RaspayIntegration {

    CustomerDto createCustomer(CustomerDto dto);
    OrderDto createOrder(OrderDto dto);
    Boolean processPayment(PaymentDto dto);
}
