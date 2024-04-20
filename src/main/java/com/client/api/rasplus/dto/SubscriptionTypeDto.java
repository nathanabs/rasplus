package com.client.api.rasplus.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionTypeDto {

    @NotBlank(message = "Campo name não pode ser nulo")
    private String name;
    @Max(value = 12, message = "Campo accessMonth não pode ser maior que 12")
    private Long accessMonths;
    @NotNull(message = "Campo price não pode ser nulo")
    private BigDecimal price;
    @NotBlank(message = "Campo productKey não pode ser nulo ou vazio")
    @Size(min = 5, max = 15)
    private String productKey;

}
