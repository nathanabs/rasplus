package com.client.api.rasplus.mapper.client;

import com.client.api.rasplus.dto.client.CreditCardDto;
import com.client.api.rasplus.dto.client.PaymentDto;

public class PaymentMapper {

    public static PaymentDto build(String customerId, String orderId, CreditCardDto dto){
        return PaymentDto.builder()
                .orderId(orderId)
                .customerId(customerId)
                .creditCard(dto)
                .build();
    }
}
