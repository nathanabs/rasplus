package com.client.api.rasplus.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDto {

    private Long cvv;
    private String documentNumber;
    private Long installments;
    private Long month;
    private String number;
    private Long year;
}
