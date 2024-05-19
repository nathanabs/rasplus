package com.client.api.rasplus.mapper.client;

import com.client.api.rasplus.dto.UserPaymentInfoDto;
import com.client.api.rasplus.dto.client.CreditCardDto;

public class CreditCardMapper {

    public static CreditCardDto build(UserPaymentInfoDto dto, String documentNumber){
        return CreditCardDto.builder()
                .documentNumber(documentNumber)
                .cvv(Long.parseLong(dto.getCardSecurityCode()))
                .number(dto.getCardNumber())
                .month(dto.getCardExpirationMonth())
                .year(dto.getCardExpirationYear())
                .installments(dto.getInstalments())
                .build();
    }
}
