package com.client.api.rasplus.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentProcessDto {

    @NotBlank(message = "Product key deve ser informado")
    private String productKey;

    private BigDecimal discount;

    @NotNull
    private UserPaymentInfoDto userPaymentInfo;
}
