package com.client.api.rasplus.mapper.client;

import com.client.api.rasplus.dto.PaymentProcessDto;
import com.client.api.rasplus.dto.client.CustomerDto;
import com.client.api.rasplus.dto.client.OrderDto;
import com.client.api.rasplus.model.User;

public class OrderMapper {

    public static OrderDto build(String customerId, PaymentProcessDto dto){
        return OrderDto.builder()
                .customerId(customerId)
                .productAcronym(dto.getProductKey())
                .discount(dto.getDiscount())
                .build();
    }
}
