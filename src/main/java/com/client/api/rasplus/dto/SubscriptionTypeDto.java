package com.client.api.rasplus.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionTypeDto {

    private String name;
    private Long accessMonths;
    private BigDecimal price;
    private String productKey;

}
