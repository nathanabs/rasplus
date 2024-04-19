package com.client.api.rasplus.mapper;

import com.client.api.rasplus.dto.SubscriptionTypeDto;
import com.client.api.rasplus.model.SubscriptionType;

public class SubscriptionTypeMapper {

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto){
        return SubscriptionType.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .accessMonths(dto.getAccessMonths())
                .productKey(dto.getProductKey())
                .build();
    }
}
