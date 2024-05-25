package com.client.api.rasplus.mapper;

import com.client.api.rasplus.dto.UserPaymentInfoDto;
import com.client.api.rasplus.model.User;
import com.client.api.rasplus.model.UserPaymentInfo;

public class UserPaymentInfoMapper {

    public static UserPaymentInfo fromDtoToEntity(UserPaymentInfoDto dto, User user){
        return UserPaymentInfo.builder()
                .id(dto.getId())
                .cardNumber(dto.getCardNumber())
                .cardExpirationMonth(dto.getCardExpirationMonth())
                .cardExpirationYear(dto.getCardExpirationYear())
                .cardSecurityCode(dto.getCardSecurityCode())
                .price(dto.getPrice())
                .datePayment(dto.getDatePayment())
                .user(user)
                .installments(dto.getInstalments())
                .build();
    }
}
